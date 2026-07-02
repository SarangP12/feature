package com.electra.automation.utilities;

import java.util.UUID;

public class RandomDataUtility {
    public static String getRandomString(int length) {
        return UUID.randomUUID().toString().substring(0, Math.min(length, 32));
    }

    public static String getRandomEmail() {
        return "user" + getRandomString(6) + "@example.com";
    }

    public static String getRandomPhoneNumber() {
        return "9" + (100000000 + (int) (Math.random() * 900000000));
    }
}
