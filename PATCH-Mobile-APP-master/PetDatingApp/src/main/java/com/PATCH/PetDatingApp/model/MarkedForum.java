package com.PATCH.PetDatingApp.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.text.SimpleDateFormat;
import java.util.Date;

@Document(collection = "markedforums")
public class MarkedForum {
    @Id
    private String id;

    private String mfid;

    private String fid;

    private String uid;

    private boolean likedForum;

    private boolean savedForum;

    private Date dateCreated;
    private Date lastModified;

    public MarkedForum() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String timestamp = sdf.format(new Date());
        mfid = "MFID-" + timestamp;
        dateCreated = new Date();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMfid() {
        return mfid;
    }

    public void setMfid(String mfid) {
        this.mfid = mfid;
    }

    public String getFid() {
        return fid;
    }

    public void setFid(String fid) {
        this.fid = fid;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
    public boolean getLikedForum() {
        return likedForum;
    }
    public boolean getSavedForum() {
        return savedForum;
    }

    public boolean isLikedForum() {
        return likedForum;
    }

    public void setLikedForum(boolean likedForum) {
        this.likedForum = likedForum;
    }

    public boolean isSavedForum() {
        return savedForum;
    }

    public void setSavedForum(boolean savedForum) {
        this.savedForum = savedForum;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Date getLastModified() {
        return lastModified;
    }

    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }

    public void setUser(User uid) {
    }
}
