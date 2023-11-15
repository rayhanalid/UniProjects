
package com.PATCH.PetDatingApp.service;

        import com.PATCH.PetDatingApp.model.Pet;
        import org.springframework.context.annotation.Bean;
        import org.springframework.stereotype.Service;
        import org.springframework.web.multipart.MultipartFile;

        import java.io.IOException;
        import java.util.List;





public interface petService {

//    List<Pet> getAllPets();

     Pet getPet(String pid);



    Pet createPet(Pet pet);

     Pet updatePet(Pet pet);



    boolean deletePet(String pid);

//    List<Pet> getPetsByUser(String uid);

//    Pet createPetForUser(String uid, Pet pet);

    // Add other pet-related methods as needed

//    String getPetImageData(String pid);
  String uploadPetImage(String pid, MultipartFile file) throws IOException;

    List<Pet> getAllPets();

//    void savePet(Pet pet);
//    String uploadImage(MultipartFile file, String fileName) throws IOException;

}
