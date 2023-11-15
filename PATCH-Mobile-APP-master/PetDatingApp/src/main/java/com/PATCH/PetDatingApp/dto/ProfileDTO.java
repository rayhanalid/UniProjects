package com.PATCH.PetDatingApp.dto;

public class ProfileDTO {
    private String uid;
    private String pid;

    // Constructor (you can create other constructors as needed)
    public ProfileDTO(String uid, String pid) {
        this.uid = uid;
        this.pid = pid;
    }

    // Getters and Setters
    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }
}
