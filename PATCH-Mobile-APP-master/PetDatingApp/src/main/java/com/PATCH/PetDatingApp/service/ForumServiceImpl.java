package com.PATCH.PetDatingApp.service;

import com.PATCH.PetDatingApp.model.Comment;
import com.PATCH.PetDatingApp.model.Forum;
import com.PATCH.PetDatingApp.model.Reply;
import com.PATCH.PetDatingApp.model.User;
import com.PATCH.PetDatingApp.repository.CommentRepository;
import com.PATCH.PetDatingApp.repository.ForumRepository;
import com.PATCH.PetDatingApp.repository.ReplyRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;


@Service
@Slf4j
public class ForumServiceImpl implements ForumService {
    private static final Logger logger = LoggerFactory.getLogger(ForumServiceImpl.class.getName());
    @Autowired
    private final ForumRepository forumRepository;
    @Autowired
    private final CommentRepository commentRepository;
    @Autowired
    private final UserService userService;
    private final ReplyRepository replyRepository;

    @Autowired
    public ForumServiceImpl(ForumRepository forumRepository, CommentRepository commentRepository, UserService userService, ReplyRepository replyRepository) {
        this.forumRepository = forumRepository;
        this.commentRepository = commentRepository;
        this.userService = userService;
        this.replyRepository= replyRepository;
    }



//    @Override
//    public Forum getForumById(String fid) {
//        return forumRepository.findById(fid).orElse(null);
//    }

//    @Override
//    public boolean deleteForumById(String fid) {
//        log.info("Deleting Forum with ID: {}", fid);
//        Forum forum = forumRepository.findByFid(fid);
//        if (forum != null) {
//            forumRepository.deleteById(fid);
//        } else {
//            log.warn("No Forum found with ID: {}", fid);
//        }
//        return false;
//    }

    @Override
    public List<Forum> getAllForums() {
        return forumRepository.findAll();
    }

//    @Override
//    public Comment createComment(String fid, Comment comment) {
//        Forum forum = forumRepository.findById(comment.getFid()).orElse(null);
//        if (forum != null) {
//            comment.setForum(forum);
//            return commentRepository.save(comment);
//        }
//        return null;
//    }



//    @Override
//    public List<Comment> getCommentsByForumId(String fid) {
//        return commentRepository.findByForumId(fid);
//    }

//    @Override
//    public Comment getCommentByCid(String cid) {
//        return commentRepository.findById(cid).orElse(null);
//    }

    @Override
    public void deleteCommentById(String cid) {
        commentRepository.deleteById(cid);
    }

//    @Override
//    public Forum getForumById(String fid) {
//        return null;
//    }

    @Override
    public Forum getForumById(String fid) {
        return forumRepository.findByFid(fid);  // Call the new method
    }
//    @Override
//    public boolean deleteForumById(Long fid) {
//        String forumId = String.valueOf(fid);
//        Forum forum = forumRepository.findByFid(forumId);
//        if (forum != null) {
//            forumRepository.deleteForumById(String.valueOf(Long.valueOf(forumId)));
//            log.info("Forum with ID {} has been deleted successfully", forumId);
//            return true;
//        } else {
//            log.warn("No Forum found with ID: {}", forumId);
//            return false;
//        }
//    }
    @Override
    public boolean deleteForumById (String fid) {
        Forum forum = forumRepository.findByFid(fid);
        if (forum !=null) {
            forumRepository.delete(forum);
            logger.info("Forum with ID {} has been deleted successfully" + deleteForumById(fid));
            return true;
        } else {
            logger.warn("No Forum found with ID: {}", fid);
            return false;
        }
    }

    @Override
    public Forum createForum(Forum forum) {
        User user = userService.findByUid(forum.getUser().getUid());  // Lookup User
        forum.setUser(user);  // Set the User
        return forumRepository.save(forum);
    }

    @Override
    public Forum createForum(Forum forum, User user) {
        user = userService.findByUid(forum.getUser().getUid());  // Lookup User
        forum.setUser(user);  // Set the User
        return forumRepository.save(forum);
    }
    @Override
    public Forum updateForum(Forum forum) {
        Forum prevForum = forumRepository.findByFid(forum.getFid());
        if (forum.getTitle() != null) {
            prevForum.setTitle(forum.getTitle());
        }
        if (forum.getCategory() != null) {
            prevForum.setCategory(forum.getCategory());
        }
        if (forum.getBody() != null) {
            prevForum.setBody(forum.getBody());
        }
        if (forum.getCreatedDate() != null) {
            prevForum.setCreatedDate(forum.getCreatedDate());
        }
        if (forum.getLastModifiedDate() != null) {
            prevForum.getLastModifiedDate();
        }
        logger.info("Forum Updated : " +prevForum.toString());
        return forumRepository.save(prevForum);

    }


    @Override
    public List<Comment> getAllComments() {
        List<Comment> comments = (List<Comment>) commentRepository.findAll();
        logger.info("Returning {} comments", comments);
        return comments;
    }

    @Override
    public List<Comment> getCommentsByFid(String fid) {
        return commentRepository.getCommentsByFid(fid);
    }

    @Override
    public Comment getComment(String fid) {
        logger.info("Comment" + fid + commentRepository.findByFid(fid));
        return commentRepository.findByFid(fid);
    }

    @Override
    public Comment getCommentByCid(String cid) {
        return commentRepository.getCommentsByCid(cid);
    }

    public Comment createComment(Comment comment) {
        User user = userService.findByUid(comment.getUser().getUid());  // Lookup User
        comment.setUser(user);  // Set the User
        // Log received comment
        logger.info("Creating comment: {}", comment);

        // Reuse passed in comment instance
        Comment saved = commentRepository.save(comment);

        // Log saved comment
        logger.info("Saved comment: {}", saved);

        return saved;

    }



    @Override
    public void deleteCommentByCid(String cid) {
        commentRepository.deleteByCid(cid);

    }
    @RestController
    public class ForumController {
        @Autowired
        private ForumService forumService;  // Inject the interface

        public ForumController(ForumService forumService) {  // Inject the interface
            this.forumService = forumService;
        }

}
    @Override
    public Reply createReply(Reply reply) {
        // Set the RID for the reply (similar to how it's done in the Comment class)
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String timestamp = sdf.format(new Date());
        reply.setRid("RID-" + timestamp);

        // Set other properties for the reply as needed
        // For example, set the dateCreated and lastModified fields
        reply.setDateCreated(new Date());
        reply.setLastModified(new Date());

        // Call replyRepository.save(reply) to save the reply to the database
        return replyRepository.save(reply);
    }
    @Override
    public boolean deleteReplyByRid(String rid) {
        Optional<Reply> optionalReply = replyRepository.findByRid(rid);
        if (optionalReply.isPresent()) {
            replyRepository.delete(optionalReply.get());
            return true; // Reply was deleted successfully
        } else {
            return false; // Reply with the given RID not found
        }
    }
    @Override
    public Reply getReplyByRid(String rid) {
        Optional<Reply> optionalReply = replyRepository.findByRid(rid);
        return optionalReply.orElse(null); // Return the reply or null if not found
    }
    @Override
    public List<Reply> getReplyByCid(String cid) {
        return replyRepository.findByCid(cid);

}
}
