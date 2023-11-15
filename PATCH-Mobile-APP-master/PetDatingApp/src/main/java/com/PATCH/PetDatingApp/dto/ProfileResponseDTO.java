package com.PATCH.PetDatingApp.dto;

import java.util.List;

public class ProfileResponseDTO {
    private List<ProfileDTO> profiles;

    // Constructor (you can create other constructors as needed)
    public ProfileResponseDTO(List<ProfileDTO> profiles) {
        this.profiles = profiles;
    }

    // Getters and Setters
    public List<ProfileDTO> getProfiles() {
        return profiles;
    }

    public void setProfiles(List<ProfileDTO> profiles) {
        this.profiles = profiles;
    }
}
