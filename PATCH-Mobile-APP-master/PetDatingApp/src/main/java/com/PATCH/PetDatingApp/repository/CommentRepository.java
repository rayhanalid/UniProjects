package com.PATCH.PetDatingApp.repository;

import com.PATCH.PetDatingApp.model.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CommentRepository extends MongoRepository<Comment, String> {
    List<Comment> findByForumId(String fid);
    List<Comment> getCommentsByFid(String Fid);
    Comment getCommentsByCid(String Cid);
    Comment findByFid(String fid);

    Comment save (Comment comment);

    void deleteById(String cid);
    void deleteByCid(String cid);
    Comment deleteCommentByCid(String cid);

//    Optional<Comment> findById(String cid);
    Comment findByCid(String cid); // Add this method to retrieve comments by CID


}


