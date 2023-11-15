package com.PATCH.PetDatingApp.service;

import com.PATCH.PetDatingApp.model.Pet;
import com.PATCH.PetDatingApp.repository.PetRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.EntityNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import static com.PATCH.PetDatingApp.service.UserServiceImpl.logger;

@Service
@Slf4j
public class PetServiceImpl implements petService {

    private PetRepository petRepository;
    private ImageUploadService imageUploadService;


    @Autowired
    public PetServiceImpl(PetRepository petRepository, ImageUploadService imageUploadService) {
        this.petRepository = petRepository;
        this.imageUploadService = imageUploadService;

    }

    @Override
    public Pet getPet(String pid) {
        logger.info("Pet: " + pid + petRepository.findByPid(pid));
        return petRepository.findByPid(pid);
    }

    @Override
    public Pet createPet(Pet pet) {
        logger.info("Pet Created: " + pet.toString());
        return petRepository.save(pet);
    }

//    @Override
//    public Pet updatePet(Pet pet) {
//        Pet prevPet = petRepository.findByPid(pet.getPid());
//        if (prevPet != null) {
//            // Update the fields of prevPet with data from the new pet object
//            prevPet.setName(pet.getName());
//            prevPet.setType(pet.getType());
//            prevPet.setBreed(pet.getBreed());
//            // Set other fields accordingly
//
//            // Save the updated pet to the repository
//            logger.info("Pet Update: " + prevPet.toString());
//            return petRepository.save(prevPet);
//        } else {
//            // Handle the case when prevPet is null
//            throw new IllegalArgumentException("Pet not found with ID: " + pet.getPid());
//        }}

//    @Override
//    public Pet updatePet(Pet update) {
//        String pid = update.getPid();
//        Pet prevPet = petRepository.findByPid(pid);
//
//        if (prevPet != null) {
//            // Update the fields of prevPet with data from the new pet object
//            // Only set the fields that are not null in the update object
//            if (update.getName() != null) {
//                prevPet.setName(update.getName());
//            }
//            if (update.getType() != null) {
//                prevPet.setType(update.getType());
//            }
//            if (update.getBreed() != null) {
//                prevPet.setBreed(update.getBreed());
//            }
//            // Set other fields accordingly
//
//            // Update lastModified to current time
////            prevPet.setLastModified(new Date());
//
//            // Save the updated pet to the repository
//            logger.info("Pet Update: " + prevPet.toString());
//            return petRepository.save(prevPet);
//        } else {
//            // Handle the case when prevPet is null
//            throw new IllegalArgumentException("Pet not found with ID: " + pid);
//        }
//    }

    @Override
    public Pet updatePet(Pet update) {
        Pet existingPet = petRepository.findByPid(update.getPid());

        if (existingPet != null) {
            // Update only the non-null fields from the update object
            if (update.getName() != null) {
                existingPet.setName(update.getName());
            }
            if (update.getType() != null) {
                existingPet.setType(update.getType());
            }
            if (update.getBreed() != null) {
                existingPet.setBreed(update.getBreed());
            }
            if (update.getColors() != null) {
                existingPet.setColors(update.getColors());
            }
            if (update.getGender() != null) {
                existingPet.setGender(update.getGender());
            }
            if (update.getWeight() != 0) {
                existingPet.setWeight(update.getWeight());
            }
            if (update.getAge() != 0) {
                existingPet.setAge(update.getAge());
            }
            if (update.getVaccineStatus() != null) {
                existingPet.setVaccineStatus(update.getVaccineStatus());
            }
            if (update.getCharacter1() != null) {
                existingPet.setCharacter1(update.getCharacter1());
            }
            if (update.getCharacter2() != null) {
                existingPet.setCharacter2(update.getCharacter2());
            }
            if (update.getCharacter3() != null) {
                existingPet.setCharacter3(update.getCharacter3());
            }
            if (update.getLike() != null) {
                existingPet.setLike(update.getLike());
            }
            if (update.getDislike() != null) {
                existingPet.setDislike(update.getDislike());
            }
            if (update.getBio() != null) {
                existingPet.setBio(update.getBio());
            }
            if (update.getLongitude() != 0.0) {
                existingPet.setLongitude(update.getLongitude());
            }
            if (update.getLatitude() != 0.0) {
                existingPet.setLatitude(update.getLatitude());
            }
            // Update lastModified to current time


            // Save the updated pet to the repository
            logger.info("Pet Update: " + existingPet.toString());
            return petRepository.save(existingPet);

        } else {
            throw new IllegalArgumentException("Pet not found with PID: " + update.getPid());
        }
    }
    @Override
    public boolean deletePet(String pid) {
        Pet pet = petRepository.findByPid(pid);
        if (pet != null) {
            petRepository.delete(pet);
            logger.info("Deleted pet: " + pid);
            return true;
        } else {
            logger.warn("Could not find Pet with ID {} to delete.", pid);
            return false;
        }
    }

    @Override
    public String uploadPetImage(String pid, MultipartFile file) throws IOException {
        // Use the ImageUploadServiceImpl to upload pet images
        return imageUploadService.uploadPetImage(pid, file);
    }
    public List<Pet> getAllPets() {
        return petRepository.findAll();
    }
}
