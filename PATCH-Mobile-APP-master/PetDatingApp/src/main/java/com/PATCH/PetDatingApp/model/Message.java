package com.PATCH.PetDatingApp.model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.*;

import java.text.SimpleDateFormat;
import java.util.Date;
@Document (collection = "messages")
@Entity
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    @Field("msid")
    private String msid;
    private String pid1; // Changed field name
    private String pid2; // Changed field name
    private String status;
    private String body;
    private Date dateCreated;

    // Constructors

    public Message() {
        // Default constructor
    }


    public Message(String pid1, String pid2, String status, String body) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String timestamp = sdf.format(new Date());
        this.msid = "MSID-" + timestamp;
        this.pid1 = pid1;
        this.pid2 = pid2;
        this.status = status;
        this.body = body;
        this.dateCreated = new Date();
    }

    // Getters and setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMsid() {
        return msid;
    }

    public void setMsid(String msid) {
        this.msid = msid;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }
}
