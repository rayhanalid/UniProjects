package com.PATCH.PetDatingApp.repository;


import com.PATCH.PetDatingApp.model.Reply;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReplyRepository extends MongoRepository<Reply, String> {
    List<Reply> findByCid(String cid);
    List<Reply> findByFid(String fid);
    void deleteByRid(String rid); // Add this method to delete a reply by RID
    // Add other custom query methods if needed
    Optional<Reply> findByRid(String rid);

    Reply findReplyByCid(String cid);
}
