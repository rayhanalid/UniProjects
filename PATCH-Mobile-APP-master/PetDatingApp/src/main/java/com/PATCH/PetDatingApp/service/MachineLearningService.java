package com.PATCH.PetDatingApp.service;

import com.PATCH.PetDatingApp.dto.*;

import java.util.List;

public interface MachineLearningService {
    List<ProfileResponse> getProfile(ProfileRequest request);

    UpdateModelResponse updateModel(UpdateModelRequest request);

    void updateModel(String pid1, String pid2, int action, String model);
}
