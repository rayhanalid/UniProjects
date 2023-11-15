package com.PATCH.PetDatingApp.model;

import jakarta.validation.constraints.NotBlank;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.text.SimpleDateFormat;
import java.util.Date;

@Document(collection = "matchhistories")
public class MatchHistory {
    @Id
    private String id;
    @NotBlank
    private String mid;
    private String pid1;
    private String pid2;
    private boolean status;
    private boolean hasInteracted;
    private Date dateCreated;
    private Date lastModified;

    public MatchHistory(String mid, String pid1, String pid2, boolean status, Date dateCreated, Date lastModified) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String timestamp = sdf.format(new Date());

        this.mid = "MID-" + timestamp;
        this.pid1 = pid1;
        this.pid2 = pid2;
        this.status = status;
        this.dateCreated = new Date();
        this.lastModified = new Date();
    }

    public MatchHistory() {
    }

    // Getters and setters for all fields

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
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

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
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
    public boolean isHasInteracted() {
        return hasInteracted;
    }

    public void setHasInteracted(boolean hasInteracted) {
        this.hasInteracted = hasInteracted;
    }
}
