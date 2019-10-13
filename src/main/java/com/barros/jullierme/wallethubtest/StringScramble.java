package com.barros.jullierme.wallethubtest;

import java.util.Collections;

public class StringScramble {
    /*String x = "hello";
    List<Character> list = new ArrayList<Character>();
    for(char c : x.toCharArray()) {
        list.add(c);
    }
    Collections.shuffle(list);
    StringBuilder builder = new StringBuilder();
    for(char c : list) {
        builder.append(c);
    }
    String shuffled = builder.toString();

    System.out.println(shuffled); //e.g. llheo
    * */
    public static String isRearranged(String base, String word) {
        base = replaceAllNonAlphabeticLetters(base);
        word = replaceAllNonAlphabeticLetters(word);

        for (String c : word.split("")) {
            if (!base.contains(c))
                return "false";

            base = base.replaceFirst(c, "");
        }

        return "true";
    }

    private static String replaceAllNonAlphabeticLetters(String value) {
        return value.replaceAll("[^a-zA-Z]", "");
    }

    public static void main(String[] args) {
        System.out.println(isRearranged("redividers", "reid"));
        System.out.println(isRearranged("win33er", "winner"));
    }
}
