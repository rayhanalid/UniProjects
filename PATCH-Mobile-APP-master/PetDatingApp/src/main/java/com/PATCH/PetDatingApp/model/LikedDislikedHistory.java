package com.PATCH.PetDatingApp.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import java.text.SimpleDateFormat;
import java.util.Date;

@Document(collection = "likeddislikedhistories")
public class LikedDislikedHistory {
    @Id
    private String id;

    private String ldid;
    private String pid1;
    private String pid2;
    private boolean action;
    private Date dateCreated;
    private Date lastModified;
    public LikedDislikedHistory(String pid1, String pid2, boolean action) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String timestamp = sdf.format(new Date());

        this.ldid = "LDID-" + timestamp;
        this.pid1 = pid1;
        this.pid2 = pid2;
        this.action = action;
        this.dateCreated = new Date();
        this.lastModified = new Date();
    }

    public LikedDislikedHistory() {
    }

    // Getters and setters for all fields

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLdid() {
        return ldid;
    }

    public void setLdid(String ldid) {
        this.ldid = ldid;
    }

    public String getPid1() {
        return pid1;
    }

    public void setPid1(String pid1) {
        this.pid1 = pid1;
    }

    public String getPid2() {
        return pid2;
    }

    public void setPid2(String pid2) {
        this.pid2 = pid2;
    }

    public boolean getAction() {
        return action;
    }

    public void setAction(boolean action) {
        this.action = action;
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
}
