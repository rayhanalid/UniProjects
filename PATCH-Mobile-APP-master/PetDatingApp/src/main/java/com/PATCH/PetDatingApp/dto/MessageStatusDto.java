package com.PATCH.PetDatingApp.dto;

public class MessageStatusDto {
    private String msid;
    private String status;

    // Constructors, getters, and setters

    public MessageStatusDto() {
        // Default constructor
    }

    public MessageStatusDto(String msid, String status) {
        this.msid = msid;
        this.status = status;
    }

    public String getMsid() {
        return msid;
    }

    public void setMsid(String msid) {
        this.msid = msid;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
