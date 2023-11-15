package com.PATCH.PetDatingApp.service;

import com.PATCH.PetDatingApp.dto.*;
import com.PATCH.PetDatingApp.model.LikedDislikedHistory;
import com.PATCH.PetDatingApp.repository.LikeDislikeHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class MachineLearningServiceImpl implements MachineLearningService {

    // You can use RestTemplate or WebClient to communicate with the Flask service
    // Here's a basic example using RestTemplate:
    private final RestTemplate restTemplate;
    @Autowired
    private LikeDislikeHistoryRepository likedDislikedHistoryRepository;

    public MachineLearningServiceImpl() {
        this.restTemplate = new RestTemplate();

    }

//    @Override
//    public ProfileResponse getProfile(ProfileRequest request) {
//        String user_id = request.getUid();
//        String pet_id = request.getPid();
//        int num_profile = request.getNum_profile();
//        double loc_filter = request.getLoc_filter();
//        int age_filter = request.getAge_filter();
//        String model = request.getModel();
//
////        String url = "http://127.0.0.1:5000/get_profile/" + user_id + "/" + pet_id + "/" + num_profile + "/" + loc_filter + "/" + age_filter + "/" + model;
////        ProfileResponse response = restTemplate.postForObject(url, null, ProfileResponse.class);
////
////        return response;
//        String url = "http://127.0.0.1:5000/get_profile/" + user_id + "/" + pet_id + "/" + num_profile + "/" + loc_filter + "/" + age_filter + "/" + model;
//        ResponseEntity<MachineLearningResponse> responseEntity = restTemplate.exchange(url, HttpMethod.POST, null, MachineLearningResponse.class);
//
//        if (responseEntity.getStatusCode() == HttpStatus.OK) {
//            MachineLearningResponse machineLearningResponse = responseEntity.getBody();
//
//            // Check if there are any profiles returned
//            if (machineLearningResponse != null && machineLearningResponse.getProfiles() != null && !machineLearningResponse.getProfiles().isEmpty()) {
//                Map<String, String> firstProfile = machineLearningResponse.getProfiles().get(0);
//
//                // Create and populate the ProfileResponse object
//                ProfileResponse profileResponse = new ProfileResponse();
//                profileResponse.setUid(firstProfile.get("uid"));
//                profileResponse.setPid(firstProfile.get("pid"));
//
//                return profileResponse;
//            }
//        }
//
//        // Return null or handle the case when no profiles are returned
//        return null;
//    }
@Override
public List<ProfileResponse> getProfile(ProfileRequest request) {
    String user_id = request.getUid();
    String pet_id = request.getPid();
    int num_profile = request.getNum_profile();
    double loc_filter = request.getLoc_filter();
    int age_filter = request.getAge_filter();
    String model = request.getModel();

    String url = "http://13.239.19.28:5000/get_profile/" + user_id + "/" + pet_id + "/" + num_profile + "/" + loc_filter + "/" + age_filter + "/" + model;

    // Make the HTTP POST request to the Flask service using RestTemplate
    ResponseEntity<ProfileResponseDTO> responseEntity = restTemplate.exchange(url, HttpMethod.POST, null, ProfileResponseDTO.class);

    if (responseEntity.getStatusCode() == HttpStatus.OK) {
        ProfileResponseDTO profilesResponseDTO = responseEntity.getBody();

        // Access the profiles from the ProfilesResponseDTO
        List<ProfileDTO> profiles = profilesResponseDTO.getProfiles();

        // Check if there are any profiles returned
        if (profiles != null && !profiles.isEmpty()) {
            // Convert the list of ProfileDTO objects to the desired format
            List<ProfileResponse> profileResponses = new ArrayList<>();
            for (ProfileDTO profile : profiles) {
                ProfileResponse profileResponse = new ProfileResponse();
                profileResponse.setUid(profile.getUid());
                profileResponse.setPid(profile.getPid());
                // Set other fields if needed, but for now, they'll remain null or default values
                profileResponses.add(profileResponse);
            }

            // Return the list of ProfileResponse objects
            return profileResponses;
        }
    }

    // Return an empty list or handle the case when no profiles are returned
    return Collections.emptyList();
}


//    @Override
//    public UpdateModelResponse updateModel(UpdateModelRequest request) {
//        // Implement the logic to send the request to the Flask machine learning service
//        // and process the response to populate the UpdateModelResponse
//        // You can use restTemplate.postForObject() or similar methods to make the POST request
//
//        // Example:
//        String url = "http://127.0.0.1:5000/update_model/<petid1>/<petid2>/<action>/<model>"; // Update with the actual URL
//        UpdateModelResponse response = restTemplate.postForObject(url, request, UpdateModelResponse.class);
//
//        return response;
//    }

    @Override
    public UpdateModelResponse updateModel(UpdateModelRequest request) {
        String pet_id1 = request.getPid1();
        String pet_id2 = request.getPid2();
        int action = request.getAction();
        String model = request.getModel();

        String url = "http://13.239.19.28:5000/get_profile/" + pet_id1 + "/" + pet_id2 + "/" + action + "/" + model;
        UpdateModelResponse response = restTemplate.postForObject(url, null, UpdateModelResponse.class);

        return response;
    }
    @Override
    public void updateModel(String pid1, String pid2, int action, String model) {
        // Call the method to update the machine learning model (you already have this part in your service)

        // Check if the document already exists in the database
        LikedDislikedHistory history = likedDislikedHistoryRepository.findByPid1AndPid2(pid1, pid2);

        if (history != null) {
            // If the document exists, update the action field
            boolean isLiked = action == 1; // 1 = liked, 0 = disliked
            history.setAction(isLiked);
            likedDislikedHistoryRepository.save(history);
        } else {
            // If the document does not exist, create a new one and save it
            boolean isLiked = action == 1; // 1 = liked, 0 = disliked
            history = new LikedDislikedHistory(pid1, pid2, isLiked);
            likedDislikedHistoryRepository.save(history);
        }
    }
//    @Override
//    public void updateModel(String pid1, String pid2, int action, String model) {
//        // Call the method to update the machine learning model (you already have this part in your service)
//
//        // Create like/dislike history object
//        boolean isLiked = action == 1; // 1 = liked, 0 = disliked
//        LikedDislikedHistory history = new LikedDislikedHistory(pid1, pid2, isLiked);
//
//        // Save like/dislike history to MongoDB using the repository
//        likedDislikedHistoryRepository.save(history);
//    }
}
