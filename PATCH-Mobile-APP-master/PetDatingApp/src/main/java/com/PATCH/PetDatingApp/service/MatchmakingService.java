package com.PATCH.PetDatingApp.service;

import com.PATCH.PetDatingApp.model.LikedDislikedHistory;
import com.PATCH.PetDatingApp.model.MatchHistory;
import com.PATCH.PetDatingApp.model.Message;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface MatchmakingService {

    static void save(LikedDislikedHistory history) {
    }

    // Like
    ResponseEntity<LikedDislikedHistory> sendLike(LikedDislikedHistory like);

    ResponseEntity<List<LikedDislikedHistory>> getAllLikes();
    ResponseEntity<LikedDislikedHistory> getLikeById(String ldid);
    ResponseEntity<List<LikedDislikedHistory>> getLikeByPid(String pid2);
    void deleteByLdid(String ldid);
//    ResponseEntity<Void> deleteLike(String ldid);
    ResponseEntity<LikedDislikedHistory> updateLike(String ldid, LikedDislikedHistory like);
    ResponseEntity<LikedDislikedHistory> sendDislike(LikedDislikedHistory dislike);
  ResponseEntity<MatchHistory> createMatch(String pid1, String pid2);
    List<MatchHistory> getAllMatches();
//    Optional<MatchHistory> findById(String mid);

    void deleteById(String mid);

//    MatchHistory getMatchHistory (String mid);
    MatchHistory findByMid(String mid);

    static void deleteMid(String mid) {

    }

}
