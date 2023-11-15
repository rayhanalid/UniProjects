//package com.PATCH.PetDatingApp.configuration;
//
//import com.google.auth.oauth2.GoogleCredentials;
//import com.google.firebase.FirebaseApp;
//import com.google.firebase.FirebaseOptions;
//import com.google.firebase.auth.FirebaseAuth;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import javax.annotation.PostConstruct;
//import java.io.FileInputStream;
//import java.io.IOException;
//
//@Configuration
//public class FirebaseConfig {
//
//    @PostConstruct
//    public void init() throws IOException {
//        // Path to your Firebase Admin SDK credentials JSON file
//        String firebaseAdminSdkPath = "C:/Users/LAPTOP/Desktop/Thesis/PetDatingApp/PetDatingApp/src/main/resources/patch-23278-firebase-adminsdk-2pjcz-2c0c973aff.json";
//
//        FileInputStream serviceAccount = new FileInputStream(firebaseAdminSdkPath);
//
//        FirebaseOptions options = new FirebaseOptions.Builder()
//                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
//                .build();
//
//        FirebaseApp.initializeApp(options);
//    }
//    @Bean
//    public FirebaseAuth firebaseAuth() {
//        return FirebaseAuth.getInstance();
//    }}
//

package com.PATCH.PetDatingApp.configuration;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseAuth;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;

@Configuration
public class FirebaseConfig {

    @PostConstruct
    public static void initialize() {
        try {
            // Load the PATCH-CREDENTIALS.json file from the classpath
            InputStream serviceAccount = FirebaseConfig.class.getClassLoader().getResourceAsStream("PATCH-CREDENTIALS.json");

            // Use GoogleCredentials to parse the InputStream
            GoogleCredentials credentials = GoogleCredentials.fromStream(serviceAccount);

            // Set up the FirebaseOptions with the loaded credentials
            FirebaseOptions options = FirebaseOptions.builder()
                    .setCredentials(credentials)
                    .build();

            // Initialize FirebaseApp with the options
            FirebaseApp.initializeApp(options);
        } catch (IOException e) {
            e.printStackTrace();
            // Handle the exception appropriately
        }}
//    public void init() throws IOException {
//
//        // Load file as resource stream
//        InputStream serviceAccount = getClass().getClassLoader().getResourceAsStream("classpath:PATCH-CREDENTIALS.json");
//
//        FirebaseOptions options = new FirebaseOptions.Builder()
//                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
//                .build();
//
//        FirebaseApp.initializeApp(options);
//    }

    @Bean
    public FirebaseAuth firebaseAuth() {
        return FirebaseAuth.getInstance();
    }

}
