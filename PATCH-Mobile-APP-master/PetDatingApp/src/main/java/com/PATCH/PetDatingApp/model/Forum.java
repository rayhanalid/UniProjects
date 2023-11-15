package com.PATCH.PetDatingApp.model;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.text.SimpleDateFormat;
import java.util.Date;

@Document(collection = "forums")
public class Forum {
    @Id
    private String id;

    @NotBlank
    private String fid;
    private String category;

    @DBRef(db = "users")
    @Field("uid")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String uid;
    private User user;
    private String title;
    private String body;
    @Field("dateCreated")
    private Date createdDate;
    @Field("lastModified")
    private Date lastModifiedDate;
    private String cid;


    public Forum(User user, String title, String body, String category) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String timestamp = sdf.format(new Date());
        this.fid = "FID-" + timestamp;
        this.user = user;
        this.title = title;
        this.body = body;
        this.category = category;
        this.createdDate = new Date();
        this.lastModifiedDate = new Date();
    }


    public String getFid() {
        return fid;
    }

    public void setFid(String fid) {
        this.fid = fid;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }
    public String getUid() {
        return uid;
    }

    public Forum orElse(Object o) {
        return null;
    }
}
