package com.PATCH.PetDatingApp.controller;

import com.PATCH.PetDatingApp.dto.*;
import com.PATCH.PetDatingApp.model.LikedDislikedHistory;
import com.PATCH.PetDatingApp.service.MachineLearningService;
import com.PATCH.PetDatingApp.service.MatchmakingService;
import com.PATCH.PetDatingApp.util.ECRAuthentication;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/machine-learning")
public class MachineLearningController {

    @Autowired
    private MachineLearningService machineLearningService;
    @Autowired
    private RestTemplate restTemplate;

//    @PostMapping("/get_profile")
//    public ResponseEntity<ProfileResponse> getProfile(@RequestBody ProfileRequest request) {
//        ProfileResponse response = machineLearningService.getProfile(request);
//        return ResponseEntity.ok(response);
//    }
//
//    @PostMapping("/update_model")
//    public ResponseEntity<UpdateModelResponse> updateModel(@RequestBody UpdateModelRequest request) {
//        UpdateModelResponse response = machineLearningService.updateModel(request);
//        return ResponseEntity.ok(response);
//    }
//@PostMapping("/get_profile/{user_id}/{pet_id}/{num_profile}/{loc_filter}/{age_filter}/{model}")
//public ResponseEntity<ProfileResponse> getProfile(@PathVariable("user_id") String userId,
//                                                  @PathVariable("pet_id") String petId,
//                                                  @PathVariable("num_profile") int numProfile,
//                                                  @PathVariable("loc_filter") double locFilter,
//                                                  @PathVariable("age_filter") int ageFilter,
//                                                  @PathVariable("model") String model) {
//
//    // Create a ProfileRequest object from the URL parameters
//    ProfileRequest request = new ProfileRequest();
//    request.setUid(userId);
//    request.setPid(petId);
//    request.setNum_profile(numProfile);
//    request.setLoc_filter(locFilter);
//    request.setAge_filter(ageFilter);
//    request.setModel(model);
//
//    ProfileResponse response = machineLearningService.getProfile(request);
//    return ResponseEntity.ok(response);
//}
@PostMapping("/get_profile/{uid}/{pid}/{num_profile}/{loc_filter}/{age_filter}/{model}")
public ResponseEntity<String> getProfile(@PathVariable String uid,
                                         @PathVariable String pid,
                                         @PathVariable int num_profile,
                                         @PathVariable double loc_filter,
                                         @PathVariable int age_filter,
                                         @PathVariable String model) {

    // Build URL using uid and pid
    String url = "http://13.239.19.28:5000/get_profile/" + uid + "/" + pid + "/" +
            num_profile + "/" + loc_filter + "/" + age_filter + "/" + model;

    String ecrAuthToken = ECRAuthentication.getECRAuthorizationToken();

    // Set up the request headers with the ECR authorization token
    HttpHeaders headers = new HttpHeaders();
    headers.setBearerAuth(ecrAuthToken);

    // Create the HTTP entity with headers
    HttpEntity<String> entity = new HttpEntity<>(headers);

    // Call Flask endpoint with the ECR authorization token
    ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);

    return response;
}



//    @PostMapping("/update_model/{pet_id1}/{pet_id2}/{action}/{model}")
//    public ResponseEntity<UpdateModelResponse> updateModel(@PathVariable("pet_id1") String petId1,
//                                                           @PathVariable("pet_id2") String petId2,
//                                                           @PathVariable("action") int action,
//                                                           @PathVariable("model") String model) {
//
//        // Create an UpdateModelRequest object from the URL parameters
//        UpdateModelRequest request = new UpdateModelRequest();
//        request.setPid1(petId1);
//        request.setPid2(petId2);
//        request.setAction(action);
//        request.setModel(model);
//
//        UpdateModelResponse response = machineLearningService.updateModel(request);
//        return ResponseEntity.ok(response);
//    }

    @PostMapping("/update_model/{pid1}/{pid2}/{action}/{model}")
    public ResponseEntity<String> updateModel(@PathVariable String pid1,
                                              @PathVariable String pid2,
                                              @PathVariable int action,
                                              @PathVariable String model) {

        // Call service to update model
        machineLearningService.updateModel(pid1, pid2, action, model);

        // Create like/dislike history object
        LikedDislikedHistory history = new LikedDislikedHistory();
        history.setPid1(pid1);
        history.setPid2(pid2);
        history.setAction(action == 1); // 1 = liked, 0 = disliked

        // Save like/dislike history
        MatchmakingService.save(history);

        // Return response
        return ResponseEntity.ok("Model updated successfully");

    }

}
