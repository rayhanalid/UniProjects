package com.PATCH.PetDatingApp.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Document(collection = "comments")
public class Comment {
    @Id
    private String id;

    @NotBlank
    private String cid;

    @NotBlank
    private String fid;

    @DBRef(db = "users")
    @Field("uid")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String uid;

    private User user;

    @NotBlank
    private String content;

//    private List<Reply> replies = new ArrayList<>();

    @Field("replies")
    private List<Reply> replies;
    @Field("dateCreated")
    private Date dateCreated;

    @Field("lastModified")
    private Date lastModified;

    private Forum forum;

    public Comment(User user, String fid, String uid, String content) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String timestamp = sdf.format(new Date());
        this.user = user;
        this.cid = "CID-" + timestamp;
        this.fid = fid;
        this.uid = uid;
        this.content = content;
        this.replies = new ArrayList<>(); // Initialize the replies list
        this.dateCreated = new Date();
        this.lastModified = new Date();

    }

    public Comment() {
    }

    public Comment(Forum forum, User user, String content, Object o) {
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }



    public List<Reply> getReplies() {
        return replies;
    }

    public void setReplies(List<Reply> replies) {
        this.replies = replies;
    }

    public void addReply(Reply reply) {
        this.replies.add(reply);
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

    public Forum getForum() {
        return forum;
    }

    public void setForum(Forum forum) {
        this.forum = forum;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
