package com.PATCH.PetDatingApp.controller;

import com.PATCH.PetDatingApp.configuration.FirebaseConfig;
import com.PATCH.PetDatingApp.dto.LoginRequest;
import com.PATCH.PetDatingApp.dto.RegisterRequest;
import com.PATCH.PetDatingApp.dto.RegistrationRequest;
import com.PATCH.PetDatingApp.model.Forum;
import com.PATCH.PetDatingApp.model.User;
import com.PATCH.PetDatingApp.model.Pet;
import com.PATCH.PetDatingApp.repository.PetRepository;
import com.PATCH.PetDatingApp.repository.UserRepository;
//import com.PATCH.PetDatingApp.service.EmailRequest;
import com.PATCH.PetDatingApp.service.ImageUploadService;
import com.PATCH.PetDatingApp.service.UserService;
import com.PATCH.PetDatingApp.service.petService;
import com.PATCH.PetDatingApp.service.UserServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.Blob;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.cloud.StorageClient;
import com.google.protobuf.ByteString;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.security.PermitAll;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import net.coobird.thumbnailator.Thumbnails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.Blob;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.StorageOptions;

import javax.imageio.ImageIO;
import javax.persistence.EntityNotFoundException;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URL;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import static com.PATCH.PetDatingApp.service.UserServiceImpl.logger;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*", allowedHeaders = "*", exposedHeaders = "Authorization")

public class UserController {


    private final UserService userService;
    private final BCryptPasswordEncoder passwordEncoder; // Inject the BCryptPasswordEncoder
    @Autowired
    private ImageUploadService imageUploadService;
    @Autowired
    private petService petService;
    @Autowired
    private PetRepository petRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private FirebaseAuth auth;
    private Storage storage;
//    @Autowired
//    private RegisterRequest registerRequest;

//    @Autowired
//    private GoogleSignInClient googleSignInClient; //initalize this bean
private static final String BUCKET_NAME = "patch-23278.appspot.com"; // Replace with your Firebase bucket name


    public UserController(UserService userService, BCryptPasswordEncoder passwordEncoder, petService petService/*, RegisterRequest registerRequest*/) throws IOException {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
        this.petService = petService;
//        this.registerRequest = registerRequest;
    }


/*
    @PostMapping("/forgetpassword")
    public void forgetPassword(@RequestBody EmailRequest request) {
        userService.forgetPassword(request);
    }
*/

//    @PostMapping("/resetpassword")
//    public void resetPassword(@RequestBody EmailRequest request) {
//        userService.resetPassword(request);
//    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable("id") String id) {
        return userService.getUser(id);
    }

    @GetMapping("")
    public List<User> getAllUser() {
        return userService.getAllUser();
    }

    //    @GetMapping("/pet/user/{user_id}")
//    public List<Pet> getPetsByUser(@PathVariable("user_id") String userId) {
//        return userService.getPetsByUser(userId);
//    }
    @PutMapping("")
    public User updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }

    @GetMapping("/{user_id}/pet")
    public List<Pet> getUserPets(@PathVariable("user_id") String userId) {
        return userService.getUserPets(userId);
    }

    @GetMapping("/pet/{id}")
    public Pet getPet(@PathVariable("id") String pid) {
        return petService.getPet(pid);
    }

    @GetMapping("/pets")
    public List<Pet> getAllPets() {

        return petService.getAllPets();

    }

    @PostMapping("/pet")
    public Pet createPet(@RequestBody Pet pet) {
        return petService.createPet(pet);
    }


    @PutMapping("/pets/{pid}")
    public ResponseEntity<?> updatePet(@PathVariable String pid, @RequestBody Pet update) {

        // Get existing pet
        Pet pet = petService.getPet(pid);

        // Retain old data if null
        if (update.getName() == null) {
            update.setName(pet.getName());
        }

        petService.updatePet(update);

        return ResponseEntity.ok("Update for pet is successful");
    }



//    @PostMapping("/pets/{petId}/images")
//    public ResponseEntity<?> uploadImage(@PathVariable String petId, @RequestParam MultipartFile image) throws IOException {
//
//        Pet pet = petService.getPet(petId);
//
//        if (pet.getImageDataList().size() >= 5) {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
//        }
//
//        BufferedImage bufferedImage = ImageIO.read(image.getInputStream());
//
//        ByteArrayOutputStream os = new ByteArrayOutputStream();
//        ImageIO.write(bufferedImage, "jpeg", os);
//
//        byte[] imageData = os.toByteArray();
//        String imageUrl = uploadToFirebase(imageData, "Pet");
//        pet.addImageData(imageData);
//        pet.getImageUrls();
//        petRepository.save(pet);
//
//        return ResponseEntity.ok().build();
//
//    }

    //ini bisa
//    @PostMapping("/pets/{petId}/images")
//    public ResponseEntity<?> uploadImage(@PathVariable String petId, @RequestParam MultipartFile image) throws IOException {
//        Pet pet = petService.getPet(petId);
//
//        if (pet.getImageDataList().size() >= 5) {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
//        }
//
//        BufferedImage bufferedImage = ImageIO.read(image.getInputStream());
//        ByteArrayOutputStream os = new ByteArrayOutputStream();
//        ImageIO.write(bufferedImage, "jpeg", os);
//        byte[] imageData = os.toByteArray();
//        String imageUrl = uploadToFirebase(imageData, "Pet");
//
//        pet.addImageData(imageData); // Assuming you want to keep the existing imageData list
//        pet.addImageUrl(imageUrl); // Add the new imageUrl to the list of imageUrls
//        petRepository.save(pet);
//
//        return ResponseEntity.ok("Your Pet picture successfully added");
//    }
    @PostMapping("/pets/{petId}/images")
    public ResponseEntity<?> uploadImage(@PathVariable String petId, @RequestParam MultipartFile image) throws IOException {
        Pet pet = petService.getPet(petId);

        if (pet.getImageDataList().size() >= 5) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        BufferedImage bufferedImage = ImageIO.read(image.getInputStream());
        ByteArrayOutputStream os = new ByteArrayOutputStream();

        // Compress and resize the image
        Thumbnails.of(bufferedImage)
                .size(375, 476)  // Set the desired size (400x600)
                .outputQuality(0.7)  // Set the desired quality (0.7)
                .outputFormat("jpeg")  // Set the output format to JPEG
                .toOutputStream(os);

        byte[] imageData = os.toByteArray();
        String imageUrl = uploadToFirebase(imageData, "Pet");

        pet.addImageData(imageData); // Assuming you want to keep the existing imageData list
        pet.addImageUrl(imageUrl); // Add the new imageUrl to the list of imageUrls
        petRepository.save(pet);

        return ResponseEntity.ok("Your Pet picture successfully added");
    }
    // Create ini  bisa
//    @PostMapping("{uid}/profileImage")
//    public ResponseEntity<?> createProfileImage(@PathVariable String uid, @RequestParam MultipartFile image) throws IOException {
//
//        User user = userRepository.findByUid(uid);
//
//        // Encode image
//        BufferedImage bufferedImage = ImageIO.read(image.getInputStream());
//        ByteArrayOutputStream os = new ByteArrayOutputStream();
//        ImageIO.write(bufferedImage, "jpeg", os);
//
//        byte[] imageData = os.toByteArray();
//
//        // Upload to /user path
//        String imageUrl = uploadToFirebase(imageData, "user");
//
//        user.setProfileImage(imageData);
//        user.setProfileImageUrl(imageUrl);
//
//        userRepository.save(user);
//
//        return ResponseEntity.ok("Profile Picture Set");
//
//    }



    @PostMapping("{uid}/profileImage")
    public ResponseEntity<?> createProfileImage(@PathVariable String uid, @RequestParam MultipartFile image) throws IOException {
        User user = userRepository.findByUid(uid);

        // Resize and compress the image
        BufferedImage bufferedImage = ImageIO.read(image.getInputStream());
        BufferedImage resizedImage = Thumbnails.of(bufferedImage)
                .size(133, 146) // Set the desired width and height here
                .outputQuality(0.5) // Set the desired compression quality (0.0 to 1.0)
                .asBufferedImage();

        ByteArrayOutputStream os = new ByteArrayOutputStream();
        ImageIO.write(resizedImage, "jpeg", os);

        byte[] imageData = os.toByteArray();

        // Upload to /user path
        String imageUrl = uploadToFirebase(imageData, "User");

        user.setProfileImage(imageData);
        user.setProfileImageUrl(imageUrl);

        userRepository.save(user);

        return ResponseEntity.ok("Profile Picture Set");
    }


    // Update ini bisa
//    @PutMapping("{uid}/profileImage")
//    public ResponseEntity<?> updateProfileImage(@PathVariable String uid, @RequestParam MultipartFile image) throws IOException {
//
//        User user = userRepository.findByUid(uid);
//
//        // Encode image
//        BufferedImage bufferedImage = ImageIO.read(image.getInputStream());
//        ByteArrayOutputStream os = new ByteArrayOutputStream();
//        ImageIO.write(bufferedImage, "jpeg", os);
//
//        byte[] imageData = os.toByteArray();
//        String imageUrl = uploadToFirebase(imageData, "user");
//
//        // Set profile image & url on user object
//        user.setProfileImage(imageData);
//        user.setProfileImageUrl(imageUrl);
//        userRepository.save(user);
//        return ResponseEntity.ok("Profile Picture Updated ");
//
//    }
    @PutMapping("{uid}/profileImage")
    public ResponseEntity<?> updateProfileImage(@PathVariable String uid, @RequestParam MultipartFile image) throws IOException {

        User user = userRepository.findByUid(uid);

        // Encode image
        BufferedImage bufferedImage = ImageIO.read(image.getInputStream());
        ByteArrayOutputStream os = new ByteArrayOutputStream();

        // Compress and resize the image
        Thumbnails.of(bufferedImage)
                .size(133, 146)  // Set the desired size (200x200)
                .outputQuality(0.5)  // Set the desired quality (0.7)
                .outputFormat("jpeg")  // Set the output format to JPEG
                .toOutputStream(os);

        byte[] imageData = os.toByteArray();
        String imageUrl = uploadToFirebase(imageData, "User");

        // Set profile image & url on user object
        user.setProfileImage(imageData);
        user.setProfileImageUrl(imageUrl);
        userRepository.save(user);
        return ResponseEntity.ok("Profile Picture Updated ");

    }

    // Delete
    @DeleteMapping("/{uid}/profileImage")
    public ResponseEntity<?> deleteProfileImage(@PathVariable String uid) {


        User user = userRepository.findByUid(uid);
        String imageUrl = user.getProfileImageUrl();
        try {

            deleteFromFirebase(imageUrl);

        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        // Delete image from storage


        user.setProfileImage(null);
        user.setProfileImageUrl(null);

        userRepository.save(user);

        return ResponseEntity.ok("Profile Picture Deleted ");

    }


    @GetMapping("pets/{pid}/images")
    public ResponseEntity<List<byte[]>> getImages(@PathVariable String pid) {

        Pet pet = petService.getPet(pid);
        List<byte[]> imageDataList = pet.getImageDataList();

        return ResponseEntity.ok(imageDataList);


    }
// ini bisa
//    @PutMapping("/pets/{pid}/images/{index}")
//    public ResponseEntity<?> updateImage(@PathVariable String pid, @PathVariable int index, @RequestParam MultipartFile image) throws IOException {
//
//        Pet pet = petService.getPet(pid);
//
//        // Encode image
//        BufferedImage bufferedImage = ImageIO.read(image.getInputStream());
//        ByteArrayOutputStream os = new ByteArrayOutputStream();
//        ImageIO.write(bufferedImage, "jpeg", os);
//        byte[] imageData = os.toByteArray();
//        String imageUrl = uploadToFirebase(imageData, "Pet");
//
//        if (index >= 0 && index < pet.getImageDataList().size()) {
//            // Update image data list and image URLs at the given index
//            pet.getImageDataList().set(index, imageData);
//            pet.getImageUrls().set(index, imageUrl);
//        } else {
//            // If the index is greater than the current size, add the new image data and URL
//            pet.addImageData(imageData);
//            pet.addImageUrl(imageUrl);
//        }

        // Update pet
//
//        // Update image data list
//        pet.getImageDataList().set(index, imageData);
//        pet.getImageDataList().set(index, imageData);
//        pet.getImageUrls().set(index, imageUrl);
// ini jgn lupa yg bawah di uncomment
//        petRepository.save(pet);
//
//        return ResponseEntity.ok("Your Pet picture successfully updated");
//
//    }
@PutMapping("/pets/{pid}/images/{index}")
public ResponseEntity<?> updateImage(@PathVariable String pid, @PathVariable int index, @RequestParam MultipartFile image) throws IOException {
    Pet pet = petService.getPet(pid);

    // Encode image
    BufferedImage bufferedImage = ImageIO.read(image.getInputStream());
    ByteArrayOutputStream os = new ByteArrayOutputStream();

    // Resize the image to 375x476 and set the output quality to 0.7
    Thumbnails.of(bufferedImage)
            .size(375, 476)
            .outputQuality(0.7)
            .outputFormat("jpeg")
            .toOutputStream(os);

    byte[] imageData = os.toByteArray();
    String imageUrl = uploadToFirebase(imageData, "Pet");

    if (index >= 0 && index < pet.getImageDataList().size()) {
        // Update image data list and image URLs at the given index
        pet.getImageDataList().set(index, imageData);
        pet.getImageUrls().set(index, imageUrl);
    } else {
        // If the index is greater than the current size, add the new image data and URL
        pet.addImageData(imageData);
        pet.addImageUrl(imageUrl);
    }

    petRepository.save(pet);

    return ResponseEntity.ok("Your Pet picture successfully updated");
}
    // Delete image
    @DeleteMapping("/pets/{pid}/images/{index}")
    public ResponseEntity<?> deleteImage(@PathVariable String pid, @PathVariable int index) {

        Pet pet = petService.getPet(pid);

        try {
            String url = pet.getImageUrls().get(index);

            deleteFromFirebase(url);

            petService.updatePet(pet);
            pet.getImageDataList().remove(index);
            pet.getImageUrls().remove(index);
            petRepository.save(pet);


            return ResponseEntity.ok("Your Pet picture successfully removed");
        } catch (IOException e) {
            // Handle exception
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

//    GoogleCredentials credentials = GoogleCredentials.fromStream(new FileInputStream("classpath:PATCH-CREDENTIALS.json"));
//
//    // Initialize Storage client
//    Storage storage = StorageOptions.newBuilder()
//            .setCredentials(credentials)
//            .build()
//            .getService();

    @PostConstruct
    private void initializeStorage() {
        try {
            // Load the PATCH-CREDENTIALS.json file from the classpath
            InputStream serviceAccount = UserController.class.getClassLoader().getResourceAsStream("PATCH-CREDENTIALS.json");

            // Initialize the Google Cloud Storage client with explicit credentials
            GoogleCredentials credentials = GoogleCredentials.fromStream(serviceAccount);
            storage = StorageOptions.newBuilder().setCredentials(credentials).build().getService();
        } catch (IOException e) {
            // Handle the exception or log the error
            e.printStackTrace();
            // You may throw an exception or handle it according to your use case
        }
    }
//    private String uploadToFirebase(byte[] imageBytes, String path) throws IOException {
//
//        String bucketName = "patch-23278.appspot.com";
//
//        // Generate unique file name
//        String fileName = UUID.randomUUID().toString();
//
//        BlobInfo blobInfo = BlobInfo.newBuilder(BlobId.of(bucketName, fileName))
//                .setContentType("image/jpeg")
//                .build();
//
//        // Convert byte array to input stream
//        InputStream is = new ByteArrayInputStream(imageBytes);
//
//        // Upload input stream
//        Blob blob = storage.create(blobInfo, is);
//
//        return blob.signUrl(1, TimeUnit.DAYS).toString();
//
//    }
private String uploadToFirebase(byte[] imageBytes, String folder) throws IOException {
    String bucketName = "patch-23278.appspot.com";
    String fileName = UUID.randomUUID().toString();
    String fullPath = folder + "/" + fileName; // Concatenate the folder with the file name

    BlobInfo blobInfo = BlobInfo.newBuilder(BlobId.of(bucketName, fullPath))
            .setContentType("image/jpeg")
            .build();

    InputStream is = new ByteArrayInputStream(imageBytes);
    Blob blob = storage.create(blobInfo, is);

    return blob.signUrl(1, TimeUnit.DAYS).toString();
}


    private void deleteFromFirebase(String fileUrl) throws IOException {

        // Get bucket name
        String bucketName = "patch-23278.appspot.com";

        // Parse file name from URL
        String fileName = new URL(fileUrl).getPath().split("/")[2];

        // Create Blob ID
        BlobId blobId = BlobId.of(bucketName, fileName);

        // Delete file
        storage.delete(blobId);

    }


//    @DeleteMapping("/pet/{id}")
//    public void deletePet(@PathVariable("id") String pid) {
//        petService.deletePet(pid);
//    }
@DeleteMapping("/pets/{id}")
public ResponseEntity<String> deletePet(@PathVariable("id") String pid) {
    petService.deletePet(pid);
    return ResponseEntity.ok("Delete pet is successful");
}
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") String uid) {
        userService.deleteUser(uid);
        return ResponseEntity.ok("Delete User is Successful");
    }


    @GetMapping("/pet/user/{user_id}")
    public List<Pet> getPetsByUser(@PathVariable("user_id") String userId) {
        return userService.getPetsByUser(userId);
    }

//    @PostMapping("/register")
//    public ResponseEntity<String> register(@RequestBody RegisterRequest request) {
//        String user = userService.register(request);
//        try {
//            String message = userService.register(request);
//            return ResponseEntity.ok("Registration successful");
//        } catch (IllegalArgumentException e) {
//            return ResponseEntity.badRequest().body(e.getMessage());
//        }
//
//
//    }
@PermitAll
@PostMapping("/register")
public ResponseEntity<String> register(@RequestBody RegisterRequest request) {
    try {
        String message = userService.register(request);
        String welcomeMessage = "Welcome to PATCH " + message;
        return ResponseEntity.ok(welcomeMessage);
    } catch (RuntimeException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}

//    @PostMapping("/login")
//    public ResponseEntity<String> login(@RequestBody LoginRequest request) {
//        try {
//            String uid = userService.login(request.getEmail(), request.getPassword());
//            return ResponseEntity.ok(uid);
//        } catch (RuntimeException e) {
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password");
//        }
//    }
@PermitAll
@PostMapping("/login")
public ResponseEntity<?> login(@RequestBody LoginRequest request) {
    try {
        String jwtToken = userService.login(request.getEmail(), request.getPassword());
        User user = userService.getUserByEmail(request.getEmail());

        if (jwtToken != null && user != null) {
            user.setJwtToken(jwtToken); // Set the JWT token in the user object
            return ResponseEntity.ok(user); // Return the user object with the JWT token
        } else {
            // Handle if token or user is null
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Login error");
        }
    } catch (RuntimeException e) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password");
    }
}
//    @PostMapping("/login")
//    public ResponseEntity<String> login(@RequestBody LoginRequest request) {
//        String uid = userService.login(request.getEmail(), request.getPassword());
//        return ResponseEntity.ok(uid);
//    }
    @GetMapping("/findByEmail/{email}")
    public User findByEmail(@PathVariable String email) {
        return userRepository.findByEmail(email);
    }


@PostMapping("/reset-password")
public ResponseEntity<String> resetPassword(@RequestParam String email) {
    userService.initiatePasswordReset(email);
    return ResponseEntity.ok("Password reset email sent successfully.");
}}

