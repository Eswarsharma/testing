package com.example.test;

/**
 * This class is used to handle string related functions
 */

public class StringHelper {

    // method to create and return the string by appending the given numbers
    public static String stringFromNumbers(int... numbers) {
        StringBuilder sNumbers = new StringBuilder();
        for (int number : numbers)
            sNumbers.append(number);
        return sNumbers.toString();
    }

    // method to check for empty or null
    public static boolean isNullOrEmpty(String value) {
        return value == null || value.length() == 0;
    }

}
