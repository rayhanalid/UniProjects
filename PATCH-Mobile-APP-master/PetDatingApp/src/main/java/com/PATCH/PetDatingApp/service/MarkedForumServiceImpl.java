package com.PATCH.PetDatingApp.service;

import com.PATCH.PetDatingApp.model.MarkedForum;
import com.PATCH.PetDatingApp.model.User;
import com.PATCH.PetDatingApp.repository.MarkedForumRepository;
import com.PATCH.PetDatingApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class MarkedForumServiceImpl implements MarkedForumService {

    private final MarkedForumRepository markedForumRepository;

    private final UserRepository userRepository;

    @Autowired
    public MarkedForumServiceImpl(MarkedForumRepository markedForumRepository, UserRepository userRepository) {
        this.markedForumRepository = markedForumRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<MarkedForum> getSavedForumsByUid(String uid) {
        return markedForumRepository.findByUidAndSavedForumTrue(uid);
    }

    @Override
    public List<MarkedForum> getLikedForumsByUid(String uid) {
        return markedForumRepository.findByUidAndLikedForumTrue(uid);
    }

//    @Override
//    public MarkedForum setSavedForum(String fid) {
//        MarkedForum markedForum = markedForumRepository.findByFid(fid);
//        if (markedForum == null) {
//            markedForum = new MarkedForum();
//            markedForum.setFid(fid);
//            markedForum.setMfid(generateMfid());
//        }
//        markedForum.setSavedForum(true);
//        markedForum.setDateCreated(new Date());
//        return markedForumRepository.save(markedForum);
//    }
//
//    @Override
//    public MarkedForum setLikedForum(String fid) {
//        MarkedForum markedForum = markedForumRepository.findByFid(fid);
//        if (markedForum == null) {
//            markedForum = new MarkedForum();
//            markedForum.setFid(fid);
//            markedForum.setMfid(generateMfid());
//        }
//        markedForum.setLikedForum(true);
//        markedForum.setDateCreated(new Date());
//        return markedForumRepository.save(markedForum);
//    }
//@Override
//public MarkedForum setSavedForum(String fid, String uid) {
//    // Find the existing marked forum for the given FID and UID
//    MarkedForum existingMarkedForum = markedForumRepository.findByFidAndUid(fid, uid);
//
//    if (existingMarkedForum != null) {
//        existingMarkedForum.setSavedForum(true);
//        existingMarkedForum.setDateCreated(new Date());
//        return markedForumRepository.save(existingMarkedForum);
//    } else {
//        // Create a new marked forum entry
//        MarkedForum markedForum = new MarkedForum();
//        markedForum.setFid(fid);
//        markedForum.setMfid(generateMfid());
//        markedForum.setSavedForum(true);
//        markedForum.setDateCreated(new Date());
//
//        // Set user reference
//        User user = userRepository.findByUid(uid);
//        markedForum.setUser(user);
//
//        return markedForumRepository.save(markedForum);
//    }
//}
//
//    @Override
//    public MarkedForum setLikedForum(String fid, String uid) {
//        // Find the existing marked forum for the given FID and UID
//        MarkedForum existingMarkedForum = markedForumRepository.findByFidAndUid(fid, uid);
//
//        if (existingMarkedForum != null) {
//            existingMarkedForum.setLikedForum(true);
//            existingMarkedForum.setDateCreated(new Date());
//            return markedForumRepository.save(existingMarkedForum);
//        } else {
//            // Create a new marked forum entry
//            MarkedForum markedForum = new MarkedForum();
//            markedForum.setFid(fid);
//            markedForum.setMfid(generateMfid());
//            markedForum.setLikedForum(true);
//            markedForum.setDateCreated(new Date());
//
//            // Set user reference
//            User user = userRepository.findByUid(uid);
//            markedForum.setUser(user);
//
//            return markedForumRepository.save(markedForum);
//        }
//    }
@Override
public MarkedForum setSavedForum(String fid, String uid) {
    // Find the existing marked forum for the given FID and UID
    MarkedForum existingMarkedForum = markedForumRepository.findByFidAndUid(fid, uid);

    if (existingMarkedForum != null) {
        existingMarkedForum.setSavedForum(true);
        existingMarkedForum.setDateCreated(new Date());
        return markedForumRepository.save(existingMarkedForum);
    } else {
        // Create a new marked forum entry
        MarkedForum markedForum = new MarkedForum();
        markedForum.setFid(fid);
        markedForum.setMfid(generateMfid());
        markedForum.setSavedForum(true);
        markedForum.setDateCreated(new Date());

        // Set user reference
        User user = userRepository.findByUid(uid);
        markedForum.setUser(user);

        return markedForumRepository.save(markedForum);
    }
}

    @Override
    public MarkedForum setLikedForum(String fid, String uid) {
        // Find the existing marked forum for the given FID and UID
        MarkedForum existingMarkedForum = markedForumRepository.findByFidAndUid(fid, uid);

        if (existingMarkedForum != null) {
            existingMarkedForum.setLikedForum(true);
            existingMarkedForum.setDateCreated(new Date());
            return markedForumRepository.save(existingMarkedForum);
        } else {
            // Create a new marked forum entry
            MarkedForum markedForum = new MarkedForum();
            markedForum.setFid(fid);
            markedForum.setMfid(generateMfid());
            markedForum.setLikedForum(true);
            markedForum.setDateCreated(new Date());

            // Set user reference
            User user = userRepository.findByUid(uid);
            markedForum.setUser(user);

            return markedForumRepository.save(markedForum);
        }
    }

    // Helper method to generate the MFID
    public String generateMfid() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String timestamp = sdf.format(new Date());
        return "MFID-" + timestamp;
    }
}
