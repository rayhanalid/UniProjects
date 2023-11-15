//package com.PATCH.PetDatingApp;
//import com.PATCH.PetDatingApp.model.*;
//import com.PATCH.PetDatingApp.repository.MarkedForumRepository;
//import com.PATCH.PetDatingApp.repository.UserRepository;
//import com.PATCH.PetDatingApp.util.SecretKeyGenerator;
//import com.google.auth.oauth2.GoogleCredentials;
//import com.google.firebase.FirebaseApp;
//import com.google.firebase.FirebaseOptions;
//import com.google.firebase.auth.FirebaseAuth;
//import com.google.firebase.auth.FirebaseAuthException;
//import com.google.firebase.auth.FirebaseToken;
//import jakarta.annotation.PostConstruct;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.data.mongodb.core.MongoTemplate;
//import org.springframework.data.mongodb.core.query.Criteria;
//import org.springframework.data.mongodb.core.query.Query;
//import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
//import org.springframework.stereotype.Component;
//import org.springframework.web.socket.config.annotation.EnableWebSocket;
//
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.io.InputStream;
//import java.security.SecureRandom;
//import java.util.Base64;
//import java.util.Objects;
//import java.util.UUID;
//
//@EnableWebSocket
//@SpringBootApplication
//@EnableMongoRepositories(repositoryImplementationPostfix = "Impl") // Specify the custom repository implementation postfix
//public class PetDatingAppApplication {
//    @Autowired
//    private UserSample userSample;
//    @Autowired
//    private MarkedForumRepository markedForumRepository;
//
//    @PostConstruct
//    public void init() {
//        userSample.run();
////        MarkedForum markedForum = new MarkedForum();
////        markedForum.setFid("FID-1688213395893");
////        markedForum.setUid("UID-20230706180530");
////        markedForum.setLikedForum(true);
////        markedForum.setSavedForum(false);
////
////        markedForumRepository.insert(markedForum);
////        MarkedForum insertedForum = markedForumRepository.findOneByFid("FID-1688213395893");
////
////        //Print log statement
////       System.out.println("Added forum: " + insertedForum);
////        String secretKey = SecretKeyGenerator.generateSecretKey();
////
////        // Print the generated secret key
////        System.out.println("Random Secret Key: " + secretKey);
//
//    }
//    public static void main(String[] args) {
//        try {
//            // Load the Firebase SDK configuration from the service account key file
//            FileInputStream serviceAccount = new FileInputStream("C:/Users/LAPTOP/Desktop/Thesis/PetDatingApp/PetDatingApp/src/main/resources/patch-23278-firebase-adminsdk-2pjcz-2c0c973aff.json");
//            FirebaseOptions options = FirebaseOptions.builder()
//                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
//                    .setDatabaseUrl("mongodb+srv://rayhanali:Rambo0101@patch.6wrxyle.mongodb.net/PATCH?retryWrites=true&w=majority")
//                    .build();
//            FirebaseApp.initializeApp(options);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        SpringApplication.run(PetDatingAppApplication.class, args);
//    }
//
//    @PostConstruct
//    public void initializeFirebaseApp() throws IOException {
//        // Load the Firebase SDK configuration from the service account key file
//        InputStream serviceAccount = Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("patch-23278-firebase-adminsdk-2pjcz-2c0c973aff.json"));
//
//        FirebaseOptions options = new FirebaseOptions.Builder()
//                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
//                .build();
//
//        FirebaseApp.initializeApp(options);
//    }
//
//    private static String generateTestToken(String uid) {
//        try {
//            String customToken = FirebaseAuth.getInstance().createCustomToken(uid);
//            return customToken;
//        } catch (FirebaseAuthException e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
//
//
////    public static void main(String[] args) {
////        SpringApplication.run(PetDatingAppApplication.class, args);
////        try {
////            FileInputStream serviceAccount = new FileInputStream("C:/Users/LAPTOP/Desktop/Thesis/PetDatingApp/PetDatingApp/src/main/resources/patch-23278-firebase-adminsdk-2pjcz-2c0c973aff.json");
////            FirebaseOptions options = FirebaseOptions.builder()
////                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
////                    .setDatabaseUrl("mongodb+srv://rayhanali:Rambo0101@patch.6wrxyle.mongodb.net/PATCH?retryWrites=true&w=majority")
////                    .build();
////            FirebaseApp.initializeApp(options);
////        } catch (IOException e) {
////            e.printStackTrace();
////        }
////        String uid = "uid_here";
////
////        // Generate a test token using the Firebase Admin SDK
////        String testToken = generateTestToken(uid);
////        System.out.println("Generated Test Token: " + testToken);
////        SpringApplication.run(PetDatingAppApplication.class, args);
////    }
////
////    @PostConstruct
////    public void initializeFirebaseApp() throws IOException {
////        // Load the Firebase SDK configuration from the service account key file
////        InputStream serviceAccount = Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("patch-23278-firebase-adminsdk-2pjcz-2c0c973aff.json"));
////
////        FirebaseOptions options = new FirebaseOptions.Builder()
////                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
////                .build();
////
////        FirebaseApp.initializeApp(options);
////    }
////
////    private static String generateTestToken(String uid) {
////        try {
////            String customToken = FirebaseAuth.getInstance().createCustomToken(uid);
////            return customToken;
////        } catch (FirebaseAuthException e) {
////            e.printStackTrace();
////            return null;
////        }
////    }
////
////}
//
//
//
//        // Replace "uid_here" with the UID of the user you want to generate a token for
//
//@Component
//class UserSample {
//    @Autowired
//    private MongoTemplate mongoTemplate;
//
//    public void run() {
//        // Create a new User
//        User user = new User("rainamra", "raina@gmail.com", "rainamw");
//
//        // Generate and set the reset token
//
//     /*   String resetToken = generateResetToken();
//        user.setResetToken(resetToken);
//*/
//
//
//
//        // Insert the new User into MongoDB
//        mongoTemplate.insert(user);
//
//        // Check that the User was added properly
//        User addedUser = mongoTemplate.findOne(
//                Query.query(Criteria.where("email").is("alphaa@gmail.com")), User.class);
//
//        // Print the added User's info
////        System.out.println("User ID: " + addedUser.getUid());
////        System.out.println("Name: " + addedUser.getName());
////        System.out.println("Email: " + addedUser.getEmail());
// /*System.out.println("Reset Token: " + addedUser.getResetToken());
//       System.out.println("Is Reset Token Valid: " + addedUser.isResetTokenValid());*/
//
////        Pet pet = new Pet();
////        pet.setUid(addedUser.getUid());
////        pet.setName("Oreo");
////        pet.setType("Cat");
////        pet.setBreed("Persian");
////        pet.setColors("Black");
////        pet.setGender("Female");
////        pet.setWeight(2);
////        pet.setAge(1);
////        pet.setVaccineStatus("Up to date");
////        pet.setCharacter1("insecure");
////        pet.setCharacter2("alert");
////        pet.setCharacter3("active");
////        pet.setLike1("Toys");
////        pet.setLike2("Treats");
////        pet.setDislike1("Loud noises");
////        pet.setDislike2("Being alone");
////
////        // Insert the new Pet into MongoDB
////        mongoTemplate.insert(pet);
////
////        // Check that the Pet was added properly
////        Pet addedPet = mongoTemplate.findOne(
////                Query.query(Criteria.where("name").is("Oreo")), Pet.class);
////
////        // Print the added Pet's info
////        System.out.println("Pet ID: " + addedPet.getPid());
////        System.out.println("Name: " + addedPet.getName());
////        System.out.println("Type: " + addedPet.getType());
////        System.out.println("Breed: " + addedPet.getBreed());
////        System.out.println("Colors: " + addedPet.getColors());
////        System.out.println("Gender: " + addedPet.getGender());
////        System.out.println("Weight: " + addedPet.getWeight());
////        System.out.println("Age: " + addedPet.getAge());
////        System.out.println("Vaccine Status: " + addedPet.getVaccineStatus());
////        System.out.println("Character 1: " + addedPet.getCharacter1());
////        System.out.println("Character 2: " + addedPet.getCharacter2());
////        System.out.println("Character 3: " + addedPet.getCharacter3());
////        System.out.println("Like 1: " + addedPet.getLike1());
////        System.out.println("Like 2: " + addedPet.getLike2());
////        System.out.println("Dislike 1: " + addedPet.getDislike1());
////        System.out.println("Dislike 2: " + addedPet.getDislike2());
////        System.out.println("User ID: " + addedPet.getUid());
////    }
//
///*
//private String generateResetToken() {
//        // Implement your logic to generate a reset token
//        // You can use UUID.randomUUID() to generate a unique token
//        // Example: return UUID.randomUUID().toString();
//        return UUID.randomUUID().toString();
//    }*/
//
//
//    @Component
//    class ForumSample {
//        @Autowired
//        private MongoTemplate mongoTemplate;
//
//        @Autowired
//        private MarkedForumRepository markedForumRepository;
//
//        public void run() {
//            // Create a new User
//            User user = mongoTemplate.findOne(Query.query(Criteria.where("email").is("raina@gmail.com")), User.class);
//
//            // Create a new Forum
//            Forum forum = new Forum(user, "Test my cat", "This is my cat Cikabaw", "community");
//
//            // Insert the new Forum into MongoDB
//            mongoTemplate.insert(forum);
//
//            // Check that the Forum was added properly
//            Forum addedForum = mongoTemplate.findOne(Query.query(Criteria.where("title").is("Test my cat")), Forum.class);
//
//            // Print the added Forum's info
//            System.out.println("FID: " + addedForum.getFid());
//            System.out.println("User: " + addedForum.getUser().getName());
//            System.out.println("Title: " + addedForum.getTitle());
//            System.out.println("Body: " + addedForum.getBody());
//            System.out.println("Category: " + addedForum.getCategory());
////            MarkedForum markedForum = new MarkedForum();
////            markedForum.setFid("1");
////            markedForum.setUid("UID-1");
////            markedForum.setLikedForum(true);
////            markedForumRepository.insert(markedForum);
////            MarkedForum insertedForum = markedForumRepository.insert(markedForum);
////            logger.info("Added forum: {}", insertedForum);
////            Logger logger = LoggerFactory.getLogger(PetDatingAppApplication.class);
//        }
//        @Component
//        class CommentSample {
//            @Autowired
//            private MongoTemplate mongoTemplate;
//
//            public void run() {
//                // Create a new User
//                User user = mongoTemplate.findOne(Query.query(Criteria.where("email").is("azka@gmail.com")), User.class);
//
//                // Create a new Forum
//                Forum forum = mongoTemplate.findOne(Query.query(Criteria.where("title").is("Introducing my cat")), Forum.class);
//
//                // Create a new Comment
//                Comment comment = new Comment(forum, user, "Nice cat!", null);
//
//                // Insert the new Comment into MongoDB
//                mongoTemplate.insert(comment);
//
//                // Check that the Comment was added properly
//                Comment addedComment = mongoTemplate.findOne(Query.query(Criteria.where("content").is("Nice cat!")), Comment.class);
//
//                // Print the added Comment's info
//                System.out.println("Comment ID: " + addedComment.getCid());
//                System.out.println("Forum: " + addedComment.getForum().getTitle());
//                System.out.println("User: " + addedComment.getUser().getName());
//                System.out.println("Content: " + addedComment.getContent());
////                System.out.println("Reply: " + addedComment.getReply());
//            }
//            }
//
//        }}}}
//
package com.PATCH.PetDatingApp;

import com.PATCH.PetDatingApp.model.User;
import com.PATCH.PetDatingApp.repository.MarkedForumRepository;
import com.PATCH.PetDatingApp.repository.UserRepository;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseToken;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.config.annotation.EnableWebSocket;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

@EnableWebSocket
@SpringBootApplication
@EnableMongoRepositories(repositoryImplementationPostfix = "Impl")
public class PetDatingAppApplication {
    @Autowired
    private UserSample userSample;

    @PostConstruct
    public void init() {
        userSample.run();
    }

    public static void main(String[] args) {
        SpringApplication.run(PetDatingAppApplication.class, args);
    }
}

@Component
class UserSample {
    @Autowired
    private MongoTemplate mongoTemplate;

    public void run() {
        // Create a new User
        User user = new User("rainamra", "raina@gmail.com", "rainamw");

        // Insert the new User into MongoDB
        mongoTemplate.insert(user);

        // Check that the User was added properly
        User addedUser = mongoTemplate.findOne(Query.query(Criteria.where("email").is("raina@gmail.com")), User.class);

        // Print the added User's info
        System.out.println("User ID: " + addedUser.getUid());
        System.out.println("Name: " + addedUser.getName());
        System.out.println("Email: " + addedUser.getEmail());
    }
}
