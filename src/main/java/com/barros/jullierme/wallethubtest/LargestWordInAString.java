package com.barros.jullierme.wallethubtest;

import java.util.Arrays;
import java.util.Comparator;

public class LargestWordInAString {

    /*
    Prior Java 8

    String max = Collections.max(Str, new Comparator<String>() {
        @Override
        public int compare(String o1, String o2) {
            return o1.length() - o2.length();
        }
    });
    */
    public static String getLargestWord(String sen) {
        if(sen == null) return null;

        return Arrays.stream(sen.split(" "))
                .map(value -> value.replaceAll("[^a-zA-Z0-9]", ""))
                .max(Comparator.comparingInt(String::length))
                .orElse(null);
    }

    public static void main(String[] args) {
        String s = "Today is the happiest day of my 1231232132132 @#!$@#%$::@#$life";
        System.out.println(getLargestWord(s));
    }
}
