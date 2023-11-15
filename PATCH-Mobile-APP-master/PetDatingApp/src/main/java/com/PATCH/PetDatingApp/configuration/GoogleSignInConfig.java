//package com.PATCH.PetDatingApp.configuration;
//
//import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
//import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
//import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
//import com.google.api.client.json.jackson2.JacksonFactory;
//import com.google.auth.oauth2.IdTokenCredentials;
//import com.google.auth.http.HttpTransportFactory;
//
//import java.io.IOException;
//import java.security.GeneralSecurityException;
//import java.util.Collections;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class GoogleSignInConfig {
//    private static final String GOOGLE_CLIENT_ID = "312154061382-38aiula6lrmu6lbivhtlue68iughiquc.apps.googleusercontent.com";
//
//    @Bean
//    public GoogleIdTokenVerifier googleIdTokenVerifier() throws GeneralSecurityException, IOException {
//        HttpTransportFactory httpTransportFactory = GoogleNetHttpTransport.newTrustedTransport();
//        return new GoogleIdTokenVerifier.Builder(httpTransportFactory, JacksonFactory.getDefaultInstance())
//                .setAudience(Collections.singletonList(GOOGLE_CLIENT_ID))
//                .build();
//    }
//
//    @Bean
//    public GoogleIdToken googleIdToken() {
//        String idToken = "your_actual_id_token_here"; // Replace this with the actual ID token received from the frontend.
//
//        return GoogleIdToken.parse(JacksonFactory.getDefaultInstance(), idToken);
//    }
//
//    @Bean
//    public IdTokenCredentials googleCredentials() throws GeneralSecurityException, IOException {
//        // Get the ID token from the client (frontend)
//        String idToken = "your_actual_id_token_here"; // Replace this with the actual ID token received from the frontend.
//
//        // Verify the ID token using the GoogleIdTokenVerifier
//        GoogleIdTokenVerifier verifier = googleIdTokenVerifier();
//        GoogleIdToken googleIdToken = verifier.verify(idToken);
//        if (googleIdToken != null) {
//            return new IdTokenCredentials.Builder()
//                    .setIdToken(googleIdToken)
//                    .setIdTokenVerifier(verifier)
//                    .build();
//        } else {
//            throw new IllegalArgumentException("Invalid ID token.");
//        }
//    }
//}
