package com.PATCH.PetDatingApp.service;//package com.PATCH.PetDatingApp.service;
//
//import com.PATCH.PetDatingApp.model.Pet;
//import com.PATCH.PetDatingApp.model.User;
//import com.PATCH.PetDatingApp.repository.PetRepository;
//import com.google.auth.oauth2.GoogleCredentials;
//import com.google.cloud.storage.Blob;
//import com.google.cloud.storage.Bucket;
//import com.google.cloud.storage.Storage;
//import com.google.cloud.storage.StorageOptions;
//import org.apache.commons.codec.binary.Base64;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.web.multipart.MultipartFile;
//
//import javax.persistence.EntityNotFoundException;
//import java.io.FileInputStream;
//import java.io.IOException;
//
//@Service
//public class ImageUploadServiceImpl implements ImageUploadService, PetImageService {
//
//    // Replace this with your actual Firebase Storage bucket name
//    private static final String BUCKET_NAME = "patch-23278.appspot.com";
//    @Autowired
//    private PetRepository petRepository;
//
//
//    @Override
//    public String uploadImage(MultipartFile file, String fileName) throws IOException {
//        try {
//            // Initialize the Google Cloud Storage client with explicit credentials
//            GoogleCredentials credentials = GoogleCredentials.fromStream(new FileInputStream("C:/Users/LAPTOP/Desktop/Thesis/PetDatingApp/PetDatingApp/src/main/resources/patch-23278-firebase-adminsdk-2pjcz-2c0c973aff.json"));
//            Storage storage = StorageOptions.newBuilder().setCredentials(credentials).build().getService();
//
//            // Get the reference to your Firebase Storage bucket
//            Bucket bucket = storage.get(BUCKET_NAME);
//
//            // Upload the image to Firebase Storage
//            Blob blob = bucket.create(fileName, file.getBytes(), file.getContentType());
//            blob.createAcl(com.google.cloud.storage.Acl.of(com.google.cloud.storage.Acl.User.ofAllUsers(), com.google.cloud.storage.Acl.Role.READER));
//
//            // After successfully uploading, get the URL of the uploaded image
//            String imageURL = String.format("https://storage.googleapis.com/%s/%s", BUCKET_NAME, fileName);
//            return imageURL;
//        } catch (IOException e) {
//            // Handle the exception or log the error
//            e.printStackTrace();
//            throw e; // You can choose to rethrow the exception or return some error response
//        }
//    }
////    @Override
////    public void uploadUserImage(String uid, MultipartFile file) throws IOException {
////        // Retrieve the User from the database
////        User user = userService.getUserByUid(uid);
////        if (user == null) {
////            throw new EntityNotFoundException("User not found with UID: " + uid);
////        }
////
////        // Convert the MultipartFile to Base64-encoded image data
////        String imageData = convertToBase64(file);
////
////        // Set the image data for the User
////        user.setImageData(imageData);
////
////        // Save the updated user to the database
////        userService.updateUser(user);
////    }
//
////    @Override
////    public String uploadPetImage(String pid, MultipartFile file) throws IOException {
////        // Retrieve the Pet from the database
////        Pet pet = petService.getPet(pid);
////        if (pet == null) {
////            throw new EntityNotFoundException("Pet not found with PID: " + pid);
////        }
////
////        // Convert the MultipartFile to Base64-encoded image data
////        String imageData = convertToBase64(file);
////
////        // Set the image data for the Pet
////        pet.setImageData(imageData.getBytes());
////
////        // Save the updated pet to the database
////        petService.updatePet(pet);
////        return imageData;
////    }
////
////
////    private String convertToBase64(MultipartFile file) throws IOException {
////        byte[] fileBytes = file.getBytes();
////        return Base64.encodeBase64String(fileBytes);
////    }
////}
//
//    @Override
//    public String uploadPetImage(String pid, MultipartFile file) throws IOException {
//        // Retrieve the Pet from the database
//        Pet pet = petRepository.findByPid(pid);
//        if (pet == null) {
//            throw new EntityNotFoundException("Pet not found with PID: " + pid);
//        }
//
//        // Convert the MultipartFile to Base64-encoded image data
//        String imageData = convertToBase64(file);
//
//        System.out.println("Image Data: " + imageData);
//        // Set the image data for the Pet
//        pet.setImageData(imageData.getBytes());
//
//        // Save the updated pet to the database
//        petRepository.save(pet);
//        return imageData;
//    }
//
//
//    private String convertToBase64(MultipartFile file) throws IOException {
//        byte[] fileBytes = file.getBytes();
//        return Base64.encodeBase64String(fileBytes);
//    }
//}

import com.PATCH.PetDatingApp.model.Pet;
import com.PATCH.PetDatingApp.repository.PetRepository;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.Blob;
import com.google.cloud.storage.Bucket;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.EntityNotFoundException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;

@Service
public class ImageUploadServiceImpl implements ImageUploadService {

    // Replace this with your actual Firebase Storage bucket name
    private static final String BUCKET_NAME = "patch-23278.appspot.com";
    private final PetRepository petRepository;

    @Autowired
    public ImageUploadServiceImpl(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    @Override
    public String uploadPetImage(String pid, MultipartFile file) throws IOException {
        // Retrieve the Pet from the database
        Pet pet = petRepository.findByPid(pid);
        if (pet == null) {
            throw new EntityNotFoundException("Pet not found with PID: " + pid);
        }

        // Convert the MultipartFile to Base64-encoded image data
        String imageData = convertToBase64(file);

        System.out.println("Image Data: " + imageData);
        // Set the image data for the Pet
        pet.setImageDataList(Collections.singletonList(imageData.getBytes()));

        // Save the updated pet to the database
        petRepository.save(pet);
        return imageData;
    }

//    public String uploadImage(MultipartFile file, String fileName) throws IOException {
//        try {
//            // Initialize the Google Cloud Storage client with explicit credentials
//            GoogleCredentials credentials = GoogleCredentials.fromStream(new FileInputStream("C:/Users/LAPTOP/Desktop/Thesis/PetDatingApp/PetDatingApp/src/main/resources/PATCH-CREDENTIALS.json"));
//            Storage storage = StorageOptions.newBuilder().setCredentials(credentials).build().getService();
//
//            // Get the reference to your Firebase Storage bucket
//            Bucket bucket = storage.get(BUCKET_NAME);
//
//            // Upload the image to Firebase Storage
//            Blob blob = bucket.create(fileName, file.getBytes(), file.getContentType());
//            blob.createAcl(com.google.cloud.storage.Acl.of(com.google.cloud.storage.Acl.User.ofAllUsers(), com.google.cloud.storage.Acl.Role.READER));
//
//            // After successfully uploading, get the URL of the uploaded image
//            return String.format("https://storage.googleapis.com/%s/%s", BUCKET_NAME, fileName);
//        } catch (IOException e) {
//            // Handle the exception or log the error
//            e.printStackTrace();
//            throw e; // You can choose to rethrow the exception or return some error response
//        }
//    }
@Override
public String uploadImage(MultipartFile file, String fileName) throws IOException {
    try {
        // Load the PATCH-CREDENTIALS.json file from the classpath
        InputStream serviceAccount = ImageUploadServiceImpl.class.getClassLoader().getResourceAsStream("PATCH-CREDENTIALS.json");

        // Initialize the Google Cloud Storage client with explicit credentials
        GoogleCredentials credentials = GoogleCredentials.fromStream(serviceAccount);
        Storage storage = StorageOptions.newBuilder().setCredentials(credentials).build().getService();

        // Get the reference to your Firebase Storage bucket
        Bucket bucket = storage.get(BUCKET_NAME);

        // Upload the image to Firebase Storage
        Blob blob = bucket.create(fileName, file.getBytes(), file.getContentType());
        blob.createAcl(com.google.cloud.storage.Acl.of(com.google.cloud.storage.Acl.User.ofAllUsers(), com.google.cloud.storage.Acl.Role.READER));

        // After successfully uploading, get the URL of the uploaded image
        return String.format("https://storage.googleapis.com/%s/%s", BUCKET_NAME, fileName);
    } catch (IOException e) {
        // Handle the exception or log the error
        e.printStackTrace();
        throw e; // You can choose to rethrow the exception or return some error response
    }
}
    private String convertToBase64(MultipartFile file) throws IOException {
        byte[] fileBytes = file.getBytes();
        return Base64.encodeBase64String(fileBytes);
    }
}