package com.PATCH.PetDatingApp.dto;



import java.util.List;

public class CustomProfileResponse {
    private List<List<String>> profiles;

    public List<List<String>> getProfiles() {
        return profiles;
    }

    public void setProfiles(List<List<String>> profiles) {
        this.profiles = profiles;
    }
}
