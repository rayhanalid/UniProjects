package com.PATCH.PetDatingApp.service;

import com.PATCH.PetDatingApp.dto.LoginRequest;
import com.PATCH.PetDatingApp.dto.RegisterRequest;
import com.PATCH.PetDatingApp.model.User;
import com.PATCH.PetDatingApp.model.Pet;

import java.util.List;

public interface UserService {
//    User register(String email, String password);

    String register(RegisterRequest request);
    String login(String email, String password);
    boolean existsByEmail(String email);
//    boolean existsByUsername(String username);

//    void login(User user);

   /* void forgetPassword(EmailRequest request);*/

//    void resetPassword(String email);
    void initiatePasswordReset(String email);

    User getUser(String id);
    List<User> getAllUser();



    User updateUser(User user);

    List<Pet> getUserPets(String uid);

//    Pet getPet(String pid);

//    Pet createPet(Pet pet);
//
//    Pet updatePet(Pet pet);

    boolean deleteUser(String uid);

//    boolean deletePet(String pid);

    List<Pet> getPetsByUser(String uid);

    Pet createPetForUser(String uid, Pet pet);

      User findByUid(String uid);




    static User findUserByEmail(String email) {
        return null;
    }

    User findByUserUid(String uid);

    User getUserByEmail(String email);
//    User login(String usernameOrEmail, String password, BCryptPasswordEncoder bCryptPasswordEncoder);

//    User login(LoginRequest loginRequest);
//    String generateJwtToken(User user);

//    String uploadImage(String pid, MultipartFile file) throws IOException;
//    String getPetImageData(String pid);
}
