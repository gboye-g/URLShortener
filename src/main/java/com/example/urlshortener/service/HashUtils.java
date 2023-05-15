package com.example.urlshortener.service;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class HashUtils {
    public static String sha256(String input, int hashLength) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hashBytes = digest.digest(input.getBytes(StandardCharsets.UTF_8));
        String hash = Base64.getUrlEncoder().withoutPadding().encodeToString(hashBytes);
        return hash.substring(0, hashLength);
    }
}
