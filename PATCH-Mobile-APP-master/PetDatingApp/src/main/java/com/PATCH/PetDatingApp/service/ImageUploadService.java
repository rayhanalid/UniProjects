package com.PATCH.PetDatingApp.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ImageUploadService {

    String uploadImage(MultipartFile file, String fileName) throws IOException;
//    void uploadUserImage(String uid, MultipartFile file) throws IOException;
    String uploadPetImage(String pid, MultipartFile file) throws IOException;

}
