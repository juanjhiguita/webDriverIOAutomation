package com.automation.mobile.utils.others;

import java.security.SecureRandom;
import java.util.Locale;

public class TestUtil {
    private static final String EMAIL_DOMAIN = "@example.com";
    private static final int EMAIL_LENGTH = 10;
    private static final int PASSWORD_LENGTH = 12;

    private static final String LOWER = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPER = LOWER.toUpperCase(Locale.ROOT);
    private static final String DIGITS = "0123456789";
    private static final String SPECIAL = "!@#$%^&*()-_=+[]{}|;:',.<>?/";

    private static final String ALL_CHARACTERS = LOWER + UPPER + DIGITS + SPECIAL;
    private static final SecureRandom RANDOM = new SecureRandom();

    public static String generateRandomEmail() {
        return generateRandomString(EMAIL_LENGTH) + EMAIL_DOMAIN;
    }

    public static String generateRandomPassword() {
        return generateRandomString(PASSWORD_LENGTH, LOWER + UPPER + DIGITS + SPECIAL);
    }

    private static String generateRandomString(int length) {
        return generateRandomString(length, LOWER + UPPER + DIGITS);
    }

    private static String generateRandomString(int length, String characterSet) {
        if (length < 1) {
            throw new IllegalArgumentException("Length must be greater than 0");
        }
        if (characterSet.isEmpty()) {
            throw new IllegalArgumentException("Character set must not be empty");
        }

        StringBuilder result = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int index = RANDOM.nextInt(characterSet.length());
            result.append(characterSet.charAt(index));
        }
        return result.toString();
    }
}
