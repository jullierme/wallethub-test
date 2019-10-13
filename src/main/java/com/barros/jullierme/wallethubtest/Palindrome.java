package com.barros.jullierme.wallethubtest;

import java.util.Arrays;

public class Palindrome {
    public static boolean isPalindrome(String value) {
        //value = value.replaceAll("[^a-zA-Z]", "");

        return value.equals(new StringBuilder(value).reverse().toString());
    }

    public static boolean isPalindrome2(String value) {
        //value = value.replaceAll("[^a-zA-Z]", "");
        //postcondition: Result := reverse(str) = str
        int length = value.length();

        /*"codePointAt" instead of "charAt" - necessary in order to handle all of Unicode
        * */
        for (int x = 0; x < length / 2; ++x) {
            if (value.charAt(x) != value.charAt(length - x - 1)) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        String[] words = {"redividers", "deified", "civic", "radar",
                "level", "rotor", "kayak", "reviver", "racecar", "redder",
                "madam", "refer"};

        Arrays.stream(words).forEach(value -> System.out.println(value + " " + isPalindrome(value)));

        Arrays.stream(words).forEach(value -> System.out.println(value + " " + isPalindrome2(value)));
    }
}
