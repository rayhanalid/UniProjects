
package com.PATCH.PetDatingApp.repository;

import com.PATCH.PetDatingApp.model.MarkedForum;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MarkedForumRepository extends MongoRepository<MarkedForum, String> {

    MarkedForum findByMfid(String mfid);

    MarkedForum findOneByFid(String fid);

    List<MarkedForum> findByUid(String uid);

    List<MarkedForum> findByLikedForum(boolean likedForum);

    List<MarkedForum> findBySavedForum(boolean savedForum);

    @Query("{ 'fid' : ?0, 'uid' : ?1 }")
    MarkedForum findByFidAndUid(String fid, String uid);

    List<MarkedForum> findByUidAndSavedForumTrue(String uid);

    List<MarkedForum> findByUidAndLikedForumTrue(String uid);

    MarkedForum findByFid(String fid);

//    MarkedForum findByUserIdAndForumId(String uid, String fid);
}
