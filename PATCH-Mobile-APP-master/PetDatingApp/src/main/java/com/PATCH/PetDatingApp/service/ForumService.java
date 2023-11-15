package com.PATCH.PetDatingApp.service;

import com.PATCH.PetDatingApp.model.Comment;
import com.PATCH.PetDatingApp.model.Forum;
import com.PATCH.PetDatingApp.model.Reply;
import com.PATCH.PetDatingApp.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ForumService {


    Forum createForum(Forum forum);
    Forum createForum (Forum forum, User user);
    Forum getForumById(String fid);
  // void deleteForumById(String fid);
    List<Forum> getAllForums();
//   Comment createComment(String fid, Comment comment);
    Forum updateForum(Forum forum);
    Comment getComment(String fid);
    Comment getCommentByCid(String cid);
    void deleteCommentById(String cid);

    //    Forum getForumById(String fid);

    boolean deleteForumById(String fid);

    List<Comment> getAllComments();

    List<Comment> getCommentsByFid(String fid);

//    Comment getCommentByCid(Long cid);


    Comment createComment(Comment comment);

    void deleteCommentByCid(String cid);

    Reply createReply(Reply reply);

    boolean deleteReplyByRid(String rid);

    Reply getReplyByRid(String rid);


    List<Reply> getReplyByCid(String cid);
//    void deleteByCid(String cid);
}
