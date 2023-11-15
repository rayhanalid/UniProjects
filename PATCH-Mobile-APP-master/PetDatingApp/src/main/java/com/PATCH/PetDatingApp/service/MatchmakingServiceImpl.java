package com.PATCH.PetDatingApp.service;

import com.PATCH.PetDatingApp.model.LikedDislikedHistory;
import com.PATCH.PetDatingApp.model.MatchHistory;
import com.PATCH.PetDatingApp.model.User;
import com.PATCH.PetDatingApp.repository.LikeDislikeHistoryRepository;
import com.PATCH.PetDatingApp.repository.MatchHistoryRepository;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class MatchmakingServiceImpl implements MatchmakingService {

    private final LikeDislikeHistoryRepository likeDislikeHistoryRepository;
    private final MatchHistoryRepository matchHistoryRepository;

    public MatchmakingServiceImpl(LikeDislikeHistoryRepository likeDislikeHistoryRepository, MatchHistoryRepository matchHistoryRepository) {
        this.likeDislikeHistoryRepository = likeDislikeHistoryRepository;
        this.matchHistoryRepository = matchHistoryRepository;
    }

    @Override
    public ResponseEntity<LikedDislikedHistory> sendLike(LikedDislikedHistory like) {
        String pid1 = like.getPid1();
        String pid2 = like.getPid2();
        boolean newAction = like.getAction();

        // Check if pid1 has already liked pid2
        LikedDislikedHistory existingLike = likeDislikeHistoryRepository.findByPid1AndPid2(pid1, pid2);
        if (existingLike != null) {
            // Check if the new action is different from the existing action
            boolean existingAction = existingLike.getAction();
            if (newAction != existingAction) {
                // Update the action to the new value
                existingLike.setAction(newAction);
                existingLike.setLastModified(new Date());
                LikedDislikedHistory updatedLike = likeDislikeHistoryRepository.save(existingLike);
                ResponseEntity<LikedDislikedHistory> response = ResponseEntity.ok(updatedLike);

                // Check if both pid1 and pid2 like each other
                boolean pid1LikesPid2 = likeDislikeHistoryRepository.existsByPid1AndPid2AndAction(pid1, pid2, true);
                boolean pid2LikesPid1 = likeDislikeHistoryRepository.existsByPid1AndPid2AndAction(pid2, pid1, true);

                if (pid1LikesPid2 && pid2LikesPid1) {
                    // Create a match if both pets have liked each other
                    createMatch(pid1, pid2);
                    HttpHeaders headers = new HttpHeaders();
                    headers.add("Match-Created", "true");
                    return ResponseEntity.ok().headers(headers).body(updatedLike);
                } else {
                    HttpHeaders headers = new HttpHeaders();
                    headers.add("Match-Created", "false");
                    return ResponseEntity.ok().headers(headers).body(updatedLike);
                }
            } else {
                // Return the existing like if the action remains the same
                return ResponseEntity.ok(existingLike);
            }
        }

        // Create a new like entry
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String timestamp = sdf.format(new Date());
        like.setLdid("LDID-" + timestamp);
        like.setDateCreated(new Date());
        like.setLastModified(new Date());

        // Save the like in the repository
        LikedDislikedHistory savedLike = likeDislikeHistoryRepository.save(like);

        // Check if both pid1 and pid2 like each other
        boolean pid1LikesPid2 = likeDislikeHistoryRepository.existsByPid1AndPid2AndAction(pid1, pid2, true);
        boolean pid2LikesPid1 = likeDislikeHistoryRepository.existsByPid1AndPid2AndAction(pid2, pid1, true);

        if (pid1LikesPid2 && pid2LikesPid1) {
            // Create a match if both pets have liked each other
            createMatch(pid1, pid2);
            HttpHeaders headers = new HttpHeaders();
            headers.add("Match-Created", "true");
            return ResponseEntity.ok().headers(headers).body(savedLike);
        } else {
            HttpHeaders headers = new HttpHeaders();
            headers.add("Match-Created", "false");
            return ResponseEntity.ok().headers(headers).body(savedLike);
        }
    }



    @Override
    public ResponseEntity<List<LikedDislikedHistory>> getAllLikes() {
        // Retrieve all likes from the repository
        List<LikedDislikedHistory> likes = likeDislikeHistoryRepository.findByAction(true);

        // Return the list of likes in the response with HTTP status 200 (OK)
        return new ResponseEntity<>(likes, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<LikedDislikedHistory> updateLike(String ldid, LikedDislikedHistory updatedLike) {
        // Retrieve the existing like by LDID
        LikedDislikedHistory existingLike = likeDislikeHistoryRepository.findByLdid(ldid);
        if (existingLike == null) {
            // Return 404 Not Found if the like does not exist
            return ResponseEntity.notFound().build();
        }

        // Update the necessary fields of the existing like
        existingLike.setAction(updatedLike.getAction());
        existingLike.setLastModified(new Date());

        // Save the updated like in the repository
        LikedDislikedHistory savedLike = likeDislikeHistoryRepository.save(existingLike);

        // Return the updated like in the response with HTTP status 200 (OK)
        return ResponseEntity.ok(savedLike);
    }


    @Override
    public ResponseEntity<LikedDislikedHistory> getLikeById(String ldid) {
        // Retrieve the like from the repository based on the LDID
        LikedDislikedHistory like = likeDislikeHistoryRepository.findByLdid(ldid);

        // Check if the like exists
        if (like != null) {
            // Return the like in the response with HTTP status 200 (OK)
            return new ResponseEntity<>(like, HttpStatus.OK);
        } else {
            // Return a not found response with HTTP status 404 (Not Found)
            return ResponseEntity.notFound().build();
        }
    }


    @Override
        public ResponseEntity<List<LikedDislikedHistory>> getLikeByPid(String pid2) {
            List<LikedDislikedHistory> likes = likeDislikeHistoryRepository.findAllByPid2AndAction(pid2, true);

            if (likes.isEmpty()) {
                return ResponseEntity.noContent().build();
            }

            return ResponseEntity.ok(likes);
        }
    @Override
    public void deleteByLdid(String Ldid) {
        likeDislikeHistoryRepository.deleteByLdid(Ldid);
    }
    @Override
    public ResponseEntity<LikedDislikedHistory> sendDislike(LikedDislikedHistory dislike) {
        // Set the necessary fields for the like
        dislike.setLdid("LDID-" + System.currentTimeMillis());
        dislike.setDateCreated(new Date());
        dislike.setLastModified(new Date());

        // Save the like in the repository
        LikedDislikedHistory savedLike = likeDislikeHistoryRepository.save(dislike);

        // Return the saved like in the response with HTTP status 201 (Created)
        return new ResponseEntity<>(savedLike, HttpStatus.CREATED);
    }


    @Override
    public ResponseEntity<MatchHistory> createMatch(String pid1, String pid2) {
        // Check if both pid1 and pid2 like each other
        boolean pid1LikesPid2 = likeDislikeHistoryRepository.existsByPid1AndPid2AndAction(pid1, pid2, true);
        boolean pid2LikesPid1 = likeDislikeHistoryRepository.existsByPid1AndPid2AndAction(pid2, pid1, true);

        if (pid1LikesPid2 && pid2LikesPid1) {
            // Create a new match
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
            String timestamp = sdf.format(new Date());
            String mid = "MID-" + timestamp;
            MatchHistory match = new MatchHistory(mid, pid1, pid2, true, new Date(), new Date());
            MatchHistory savedMatch = matchHistoryRepository.save(match);
            return new ResponseEntity<>(savedMatch, HttpStatus.CREATED);
        }

        // Return null or handle accordingly if both pets haven't liked each other
        return ResponseEntity.notFound().build();
    }
    @Override
    public List<MatchHistory> getAllMatches() {
        return matchHistoryRepository.findAll();
    }

    @Override
    public MatchHistory findByMid(String mid) {
        return matchHistoryRepository.findByMid(mid);
    }


    @Override
    public void deleteById(String mid) {
        matchHistoryRepository.deleteById(mid);
    }


}

