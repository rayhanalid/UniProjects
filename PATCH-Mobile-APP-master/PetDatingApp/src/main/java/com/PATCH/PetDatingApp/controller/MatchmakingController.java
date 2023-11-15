package com.PATCH.PetDatingApp.controller;

import com.PATCH.PetDatingApp.model.LikedDislikedHistory;
import com.PATCH.PetDatingApp.model.MatchHistory;
import com.PATCH.PetDatingApp.repository.MatchHistoryRepository;
import com.PATCH.PetDatingApp.service.MatchmakingService;
import com.PATCH.PetDatingApp.repository.LikeDislikeHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/matchmaking")
public class MatchmakingController {
    @Autowired
    private final MatchmakingService matchmakingService;
    @Autowired
    private final LikeDislikeHistoryRepository likeDislikeHistoryRepository;
    @Autowired
    private final MatchHistoryRepository matchHistoryRepository;

    public MatchmakingController(MatchmakingService matchmakingService, LikeDislikeHistoryRepository likeDislikeHistoryRepository, MatchHistoryRepository matchHistoryRepository) {
        this.matchmakingService = matchmakingService;
        this.likeDislikeHistoryRepository = likeDislikeHistoryRepository;
        this.matchHistoryRepository = matchHistoryRepository;
    }

    @PostMapping("/likedislike")
    public ResponseEntity<LikedDislikedHistory> sendLike(@RequestBody LikedDislikedHistory like) {
        return matchmakingService.sendLike(like);
    }


    @GetMapping("/likedislike")
    public ResponseEntity<List<LikedDislikedHistory>> getAllLikes() {
        return matchmakingService.getAllLikes();
    }

    @PutMapping("/matchmaking/likedislike/{ldid}")
    public ResponseEntity<LikedDislikedHistory> updateLike(@PathVariable String ldid, @RequestBody LikedDislikedHistory like) {
        // Retrieve the existing like by LDID
        LikedDislikedHistory existingLike = likeDislikeHistoryRepository.findByLdid(ldid);
        if (existingLike == null) {
            // Return 404 Not Found if the like does not exist
            return ResponseEntity.notFound().build();
        }

        // Update the necessary fields of the existing like
        existingLike.setAction(like.getAction());
        existingLike.setLastModified(new Date());

        // Save the updated like in the repository
        LikedDislikedHistory updatedLike = likeDislikeHistoryRepository.save(existingLike);

        // Return the updated like in the response with HTTP status 200 (OK)
        return ResponseEntity.ok(updatedLike);
    }

    @GetMapping("/likedislike/{ldid}")
    public ResponseEntity<LikedDislikedHistory> getLikeByLdid(@PathVariable String ldid) {
        return matchmakingService.getLikeById(ldid);
    }

    @GetMapping("/likedislike/pet/{pid2}")
    public ResponseEntity<List<LikedDislikedHistory>> getLikeByPid(@PathVariable String pid2) {
        return matchmakingService.getLikeByPid(pid2);
    }

//    @DeleteMapping("/likedislike/{ldid}")
//    public void deleteByLdid(@PathVariable String ldid) {
//        matchmakingService.deleteByLdid(ldid);
//    }
    @DeleteMapping("/likedislike/{ldid}")
    public ResponseEntity<String> deleteByLdid(@PathVariable String ldid) {
        matchmakingService.deleteByLdid(ldid);
        return ResponseEntity.ok("Delete Like or Dislike is successful");
    }

    @PostMapping("/match")
    public ResponseEntity<MatchHistory> createMatch(@RequestBody MatchHistory match) {
        // Perform validation and necessary checks before creating the match
        match.setHasInteracted(false); // Initialize to false

        // Save the match in the matchhistories collection
        matchHistoryRepository.save(match);

        return ResponseEntity.ok(match);
    }

    @GetMapping("/matchhistories")
    public ResponseEntity<List<MatchHistory>> getAllMatchHistories() {
        List<MatchHistory> matchHistories = matchHistoryRepository.findAll();
        return ResponseEntity.ok(matchHistories);
    }

//    @GetMapping("/matchhistories/{mid}")
//    public ResponseEntity<MatchHistory> getMatchHistoryById(@PathVariable String mid) {
//        Optional<MatchHistory> matchHistory = matchHistoryRepository.findById(mid);
//        return matchHistory.map(ResponseEntity::ok)
//                .orElse(ResponseEntity.notFound().build());
//    }

    @GetMapping("/matchhistories/{mid}")
    public MatchHistory getMid(@PathVariable String mid) {
        return matchmakingService.findByMid(mid);
    }


    @DeleteMapping("/matchhistories/{mid}")
    public ResponseEntity<String> deleteMatchHistoryById(@PathVariable String mid) {
        matchHistoryRepository.deleteByMid(mid);
        return ResponseEntity.ok("Match Deleted");
    }


}

