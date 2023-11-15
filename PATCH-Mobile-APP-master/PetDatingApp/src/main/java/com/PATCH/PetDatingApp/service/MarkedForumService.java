package com.PATCH.PetDatingApp.service;

import com.PATCH.PetDatingApp.model.MarkedForum;

import java.util.List;

public interface MarkedForumService {

    List<MarkedForum> getSavedForumsByUid(String uid);

    List<MarkedForum> getLikedForumsByUid(String uid);

    MarkedForum setSavedForum(String fid, String uid);

    MarkedForum setLikedForum(String fid, String uid);
    String generateMfid();
}
