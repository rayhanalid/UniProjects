package com.PATCH.PetDatingApp.repository;

import com.PATCH.PetDatingApp.model.Comment;
import com.PATCH.PetDatingApp.model.Forum;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ForumRepository extends MongoRepository<Forum, String> {
    Optional<Forum> findById(String fid);

    Forum save(Forum forum);
//    boolean deleteForumById(Long fid);
    boolean deleteForumById (String fid);
    void deleteById(String fid);

    Forum findByFid(String fid);
    List<Comment> getCommentsByFid(String Fid);


    Comment save(Comment comment);
    Optional<Comment> findByCid(String cid);
}
