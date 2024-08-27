package com.example.bookmyshow_240824.services;

import java.security.SecureRandom;
import java.util.Random;

public class RandomStringGenerationService {
    //private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final Random RANDOM = new SecureRandom();
    private static final int LENGTH = 7;

    public static String generateRandomAlphanumericString() {
        StringBuilder sb = new StringBuilder(LENGTH);
        for (int i = 0; i < LENGTH; i++) {
            sb.append(CHARACTERS.charAt(RANDOM.nextInt(CHARACTERS.length())));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(generateRandomAlphanumericString());
    }
}
