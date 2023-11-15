package com.PATCH.PetDatingApp.util;

import java.security.SecureRandom;
import java.util.Base64;

public class SecretKeyGenerator {
    public static String generateSecretKey() {
        SecureRandom secureRandom = new SecureRandom();
        byte[] keyBytes = new byte[64];
        secureRandom.nextBytes(keyBytes);
        return Base64.getEncoder().encodeToString(keyBytes);
    }
}
