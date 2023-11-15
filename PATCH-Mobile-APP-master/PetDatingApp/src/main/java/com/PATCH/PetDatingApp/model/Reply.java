package com.PATCH.PetDatingApp.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.annotation.Id;


import java.text.SimpleDateFormat;
import java.util.Date;

public class Reply {
    @Id
    private String id;
    @NotBlank
    private String rid;

    @NotBlank
    private String cid;

    @NotBlank
    private String fid;

    @NotBlank
    private String uid;

    private User user;

    @NotBlank
    private String reply;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Date dateCreated;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Date lastModified;

    private Forum forum;

    public Reply() {
    }

    public Reply(String cid, String fid, String uid, String reply) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyMMddHHmmss");
        String timestamp = sdf.format(new Date());
        this.rid = "RID-" + timestamp;
        this.cid = cid;
        this.fid = fid;
        this.uid = uid;
        this.reply = reply;
        this.dateCreated = new Date();
        this.lastModified = new Date();
    }

    public String getRid() {
        return rid;
    }

    public void setRid(String rid) {
        this.rid = rid;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
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

    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
