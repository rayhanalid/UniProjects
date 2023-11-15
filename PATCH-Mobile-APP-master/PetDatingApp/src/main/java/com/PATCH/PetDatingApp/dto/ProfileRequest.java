package com.PATCH.PetDatingApp.dto;

public class ProfileRequest {
    private String uid;
    private String pid;
    private int num_profile;
    private double loc_filter;
    private int age_filter;
    private String model;

    // Add getters and setters for the fields

    public String getUid() {
        return uid;
    }

    public void setUid(String user_id) {
        this.uid = user_id;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public int getNum_profile() {
        return num_profile;
    }

    public void setNum_profile(int num_profile) {
        this.num_profile = num_profile;
    }

    public double getLoc_filter() {
        return loc_filter;
    }

    public void setLoc_filter(double loc_filter) {
        this.loc_filter = loc_filter;
    }

    public int getAge_filter() {
        return age_filter;
    }

    public void setAge_filter(int age_filter) {
        this.age_filter = age_filter;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
