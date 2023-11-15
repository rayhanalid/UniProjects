    package com.PATCH.PetDatingApp.controller;

    import com.PATCH.PetDatingApp.model.Comment;
    import com.PATCH.PetDatingApp.model.Forum;
    import com.PATCH.PetDatingApp.model.Reply;
    import com.PATCH.PetDatingApp.model.User;
    import com.PATCH.PetDatingApp.repository.CommentRepository;
    import com.PATCH.PetDatingApp.repository.ForumRepository;
    import com.PATCH.PetDatingApp.repository.ReplyRepository;
    import com.PATCH.PetDatingApp.service.ForumService;
    import com.PATCH.PetDatingApp.service.UserService;

    import org.slf4j.Logger;
    import org.slf4j.LoggerFactory;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.http.HttpStatus;
    import org.springframework.http.ResponseEntity;
    import org.springframework.web.bind.annotation.*;

    import java.text.SimpleDateFormat;
    import java.util.Date;
    import java.util.List;

    import static com.PATCH.PetDatingApp.service.UserServiceImpl.logger;

    @RestController
    @RequestMapping("/forum")
    public class ForumController {
        private static final Logger log = LoggerFactory.getLogger(ForumController.class);
        private final ForumService forumService;
        @Autowired
        private UserService userService;
        @Autowired
        private ForumRepository forumRepository;
        @Autowired
        private CommentRepository commentRepository;
        private ReplyRepository replyRepository;

        @Autowired
        public ForumController(ForumService forumService, ReplyRepository replyRepository, UserService userService, ForumRepository forumRepository, CommentRepository commentRepository) {
            this.forumService = forumService;
            this.userService = userService;
            this.forumRepository = forumRepository;
            this.commentRepository = commentRepository;
            this.replyRepository = replyRepository;
        }


        // Forum Endpoints

        @GetMapping
        public ResponseEntity<List<Forum>> getAllForums() {
            List<Forum> forums = forumService.getAllForums();
            return new ResponseEntity<>(forums, HttpStatus.OK);
        }


        @PostMapping("")
        public ResponseEntity<Forum> createForum(@RequestBody Forum forum) {
            log.info("Creating new Forum: {}", forum);
            if (forum.getUser() == null) {
                return ResponseEntity.badRequest().build();
            }
            try {
                User user = userService.findByUid(forum.getUser().getUid());
                log.info("Found user: {}", user);
                Forum createdForum = forumService.createForum(forum, user);
                log.info("Forum User: {}", forum.getUser());
                log.info("Forum created: {}", createdForum);
                return new ResponseEntity<>(createdForum, HttpStatus.CREATED);
            } catch (Exception e) {
                log.error("Error creating Forum", e);
                return ResponseEntity.badRequest().build();
            }
        }
        @PutMapping("")
        public Forum updateForum(@RequestBody Forum forum) {
            return forumService.updateForum(forum);
        }
        @GetMapping("/{fid}")
        public Forum getForumById(@PathVariable("fid") String fid) {

            log.info("Getting Forum: {}", fid);
            return forumService.getForumById(fid);
        }
//        @DeleteMapping("/{fid}")
//        public void deleteForumById(@PathVariable("fid")String fid) {
//            forumService.deleteForumById(fid);
//        }

        @DeleteMapping("/{fid}")
        public ResponseEntity<String> deleteForumById(@PathVariable("fid") String fid) {
            forumService.deleteForumById(fid);
            return ResponseEntity.ok("Forum successfully deleted");
        }
        @GetMapping("/comment")
        public List<Comment> getAllComments() {
            return forumService.getAllComments();
        }

        @GetMapping("/comment/{fid}")
        public List<Comment> getCommentsByFid(@PathVariable("fid") String fid) {
            return forumService.getCommentsByFid(fid);

        }
        @GetMapping("/comment/by-cid/{cid}")
       public Comment getCommentByCid(@PathVariable("cid") String cid) {
            return forumService.getCommentByCid(cid);

        }


@PostMapping("/comment")
public ResponseEntity<Comment> createComment(@RequestBody Comment comment) {

    // Lookup forum
    Forum forum = forumService.getForumById(comment.getFid());

    // Generate CID
    Date now = new Date();
    SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
    String dateString = formatter.format(now);

    String cid = "CID-" + dateString;

    // Set fields
    comment.setCid(cid);
    comment.setDateCreated(new Date());
    comment.setLastModified(new Date());
    comment.setForum(forum);

    // Save comment
    Comment saved = commentRepository.save(comment);

    return ResponseEntity.ok(saved);

}


//        @DeleteMapping("/comment/by-cid/{cid}")
//        public void deleteCommentByCid(@PathVariable("cid") String cid) {
//            forumService.deleteCommentByCid(cid);
//            }
@DeleteMapping("/comment/by-cid/{cid}")
public ResponseEntity<String> deleteCommentByCid(@PathVariable("cid") String cid) {
    forumService.deleteCommentByCid(cid);
    return ResponseEntity.ok("Comment successfully deleted");
}

        //        @PostMapping("/reply")
//        public ResponseEntity<Reply> createReply(@RequestBody Reply reply) {
//            Reply createdReply = forumService.createReply(reply);
//            return new ResponseEntity<>(createdReply, HttpStatus.CREATED);
//        }
@PostMapping("/reply")
public ResponseEntity<Reply> createReply(@RequestBody Reply reply) {
    // Lookup the comment that the reply belongs to
    Comment comment = commentRepository.findByCid(reply.getCid());

    // Make sure the comment exists
    if (comment == null) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    // Set fields
    reply.setFid(comment.getFid());
    reply.setUid(comment.getUid());
    reply.setDateCreated(new Date());
    reply.setLastModified(new Date());

    // Save the reply
    Reply createdReply = forumService.createReply(reply);

    // Add the reply to the comment's replies list
    comment.addReply(reply);

    // Save the updated comment (with the new reply)
    commentRepository.save(comment);

    return new ResponseEntity<>(createdReply, HttpStatus.CREATED);
}


//        @DeleteMapping("/reply/{rid}")
//        public ResponseEntity<Void> deleteReply(@PathVariable String rid) {
//            boolean deleted = forumService.deleteReplyByRid(rid);
//            if (deleted) {
//                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//            } else {
//                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//            }
//        }
@DeleteMapping("/reply/{rid}")
public ResponseEntity<String> deleteReply(@PathVariable String rid) {
    boolean deleted = forumService.deleteReplyByRid(rid);
    if (deleted) {
        return ResponseEntity.ok("Reply successfully deleted");
    } else {
        return ResponseEntity.notFound().build();
    }
}

        @GetMapping("/reply/by-rid/{rid}")
        public ResponseEntity<Reply> getReplyByRid(@PathVariable String rid) {
            Reply reply = forumService.getReplyByRid(rid);
            if (reply != null) {
                return ResponseEntity.ok(reply); // Return the reply if found
            } else {
                return ResponseEntity.notFound().build(); // Return 404 Not Found if reply not found
            }

        }
        @GetMapping("/reply/by-cid/{cid}")
        public ResponseEntity<List<Reply>> getReplyByCid(@PathVariable String cid) {
            List<Reply> replies = forumService.getReplyByCid(cid);
            if (!replies.isEmpty()) {
                return ResponseEntity.ok(replies);
            } else {
                return ResponseEntity.notFound().build();
            }
        }
    }
