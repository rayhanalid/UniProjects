package com.PATCH.PetDatingApp.repository;

import com.PATCH.PetDatingApp.model.LikedDislikedHistory;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LikeDislikeHistoryRepository extends MongoRepository<LikedDislikedHistory, String> {
    LikedDislikedHistory findByLdid(String ldid);
    List<LikedDislikedHistory> findByAction(boolean action);
    List<LikedDislikedHistory> findByPid1(String pid1);
    List<LikedDislikedHistory> findByPid2(String pid2);
    List<LikedDislikedHistory> findAllByPid2AndAction(String pid2, boolean action);

//    void deleteByPid(String pid1);
    void deleteByLdid(String ldid);

    LikedDislikedHistory findByPid1AndPid2(String pid1, String pid2);

//    boolean existsByPid1AndPid2(String pid2, String pid1);

    boolean existsByPid1AndPid2AndAction(String pid1, String pid2, boolean action);
}
