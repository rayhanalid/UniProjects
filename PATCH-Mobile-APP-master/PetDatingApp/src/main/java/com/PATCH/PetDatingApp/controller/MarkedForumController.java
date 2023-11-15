package com.PATCH.PetDatingApp.controller;

import com.PATCH.PetDatingApp.model.MarkedForum;
import com.PATCH.PetDatingApp.model.User;
import com.PATCH.PetDatingApp.repository.MarkedForumRepository;
import com.PATCH.PetDatingApp.repository.UserRepository;
import com.PATCH.PetDatingApp.service.MarkedForumService;
import com.PATCH.PetDatingApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;


@RestController
@RequestMapping("/marked-forum")

public class MarkedForumController {
    @Autowired
    private UserRepository userRepository;

    private final MarkedForumService markedForumService;
    @Autowired
    MarkedForumRepository markedForumRepository;

    @Autowired
    public MarkedForumController(MarkedForumService markedForumService) {
        this.markedForumService = markedForumService;
    }

    // Endpoint to get saved forums by UID
    @GetMapping("/saved-forums/{uid}")
    public ResponseEntity<List<MarkedForum>> getSavedForumsByUid(@PathVariable("uid") String uid) {
        List<MarkedForum> savedForums = markedForumService.getSavedForumsByUid(uid);
        return new ResponseEntity<>(savedForums, HttpStatus.OK);
    }

    // Endpoint to get liked forums by UID
    @GetMapping("/liked-forums/{uid}")
    public ResponseEntity<List<MarkedForum>> getLikedForumsByUid(@PathVariable("uid") String uid) {
        List<MarkedForum> likedForums = markedForumService.getLikedForumsByUid(uid);
        return new ResponseEntity<>(likedForums, HttpStatus.OK);
    }

    // Endpoint to set saved forum by FID
    @PostMapping("/set-saved-forum/{fid}")
    public ResponseEntity<MarkedForum> setSavedForum(@PathVariable("fid") String fid, String uid) {
        MarkedForum markedForum = markedForumService.setSavedForum(fid, uid);
        return new ResponseEntity<>(markedForum, HttpStatus.OK);
    }

    // Endpoint to set liked forum by FID
    @PostMapping("/set-liked-forum/{fid}")
    public ResponseEntity<MarkedForum> setLikedForum(@PathVariable("fid") String fid, String uid) {
        MarkedForum markedForum = markedForumService.setLikedForum(fid, uid);
        return new ResponseEntity<>(markedForum, HttpStatus.OK);
    }

//    @PostMapping("/users/{uid}/marked-forums")
//    public MarkedForum markForum(@PathVariable String uid, @RequestBody MarkedForum markedForum) {
//
//        // Set user reference
//        markedForum.setUser(userRepository.findByUid(uid));
//
//        // Save to database
//        markedForumRepository.save(markedForum);
//
//        return markedForum;
//    }

//    @PostMapping("/users/{uid}/marked-forums")
//    public MarkedForum markForum(@PathVariable String uid, @RequestBody MarkedForum markedForum) {
//        // Get the FID from the request
//        String fid = markedForum.getFid();
//
//        // Find the existing marked forum for the given FID and UID
//        MarkedForum existingMarkedForum = markedForumRepository.findByFidAndUid(fid, uid);
//
//        if (existingMarkedForum != null) {
//            // Update the likedForum and savedForum values if provided
//            Boolean newLiked = markedForum.getLikedForum();
//            if (newLiked != null) {
//                existingMarkedForum.setLikedForum(newLiked);
//            }
//
//            Boolean newSaved = markedForum.getSavedForum();
//            if (newSaved != null) {
//                existingMarkedForum.setSavedForum(newSaved);
//            }
//
//            // Save the updated marked forum
//            markedForumRepository.save(existingMarkedForum);
//            return existingMarkedForum;
//        } else {
//            // Set user reference
//            User user = userRepository.findByUid(uid);
//            markedForum.setUser(user);
//
//            // Save the new marked forum
//            markedForumRepository.save(markedForum);
//            return markedForum;
//        }
//    }
@PostMapping("/users/{uid}/marked-forums")
public MarkedForum markForum(@PathVariable String uid, @RequestBody MarkedForum markedForum) {
    User user = userRepository.findByUid(uid);
    markedForum.setUser(user);

    // Find existing marked forum for the given fid and uid
    MarkedForum existingMarkedForum = markedForumRepository.findByFidAndUid(markedForum.getFid(), uid);

    // If the existing marked forum is found, update it
    if (existingMarkedForum != null) {
        existingMarkedForum.setLikedForum(markedForum.getLikedForum());
        existingMarkedForum.setSavedForum(markedForum.getSavedForum());
        return markedForumRepository.save(existingMarkedForum);
    } else {
        // Generate a new MFID since it's a new entry
        markedForum.setMfid(markedForumService.generateMfid()); // Use the service to generate the MFID
        return markedForumRepository.save(markedForum);
    }
}


    // Find existing marked forum
//        @PutMapping("/marked-forums/{mfid}")
//        public MarkedForum updateMarkedForum(@PathVariable String mfid, @RequestBody MarkedForum update) {
//
//            MarkedForum original = markedForumRepository.findByMfid(mfid);
//
//            Boolean newSaved = update.getSavedForum();
//        // Copy over new liked value if provided
//        if(newSaved != null) {
//
//            // Compare new to old
//            if(!newSaved.equals(original.getSavedForum())) {
//                original.setSavedForum(newSaved);
//            }
//
//        Boolean newLiked = update.getLikedForum();
//
//// Check if new liked value provided
//        if(newLiked != null) {
//
//            // Compare new to old
//            if(!newLiked.equals(original.getLikedForum())) {
//                original.setLikedForum(newLiked);
//            }
//
//        // Save updated version
//        markedForumRepository.save(original);
//
//
//    }
//
//        return original;
//    } markedForumRepository.save(original);
//
//    return original;
//    }}




    @PutMapping("/marked-forums/{mfid}")
    public ResponseEntity<String> updateMarkedForum(@PathVariable String mfid, @RequestBody MarkedForum update) {

        MarkedForum original = markedForumRepository.findByMfid(mfid);

        Boolean newSaved = update.getSavedForum();
        // Copy over new saved value if provided
        if (newSaved != null) {
            // Compare new to old
            if (!newSaved.equals(original.getSavedForum())) {
                original.setSavedForum(newSaved);
            }
        }

        Boolean newLiked = update.getLikedForum();
        // Check if new liked value provided
        if (newLiked != null) {
            // Compare new to old
            if (!newLiked.equals(original.getLikedForum())) {
                original.setLikedForum(newLiked);
            }
        }

        // Save updated version
        markedForumRepository.save(original);

        return ResponseEntity.ok("Update successful");
    }}