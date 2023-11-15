package com.PATCH.PetDatingApp.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface PetImageService {
    String uploadPetImage(String pid, MultipartFile file) throws IOException;
}
