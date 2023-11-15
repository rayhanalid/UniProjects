    package com.PATCH.PetDatingApp.configuration;

    import jakarta.annotation.PostConstruct;
    import org.springframework.beans.factory.annotation.Value;
    import org.springframework.stereotype.Component;

    import java.security.SecureRandom;
    import java.util.Base64;

    @Component
    public class JwtConfig {
        public static final long EXPIRATION_TIME = 7 * 24 * 60 * 60 * 1000; // 1 week in milliseconds
        private final String secretKey;

        public JwtConfig(@Value("${JWT_SECRET_KEY}") String secretKey) {
            this.secretKey = secretKey;
        }

        // Getter method for the secret key
        public String getSecretKey() {
            return secretKey;
        }
        @PostConstruct
        public void postConstruct() {
            System.out.println("JWT_SECRET_KEY from application.properties: " + secretKey);
        }

    }
