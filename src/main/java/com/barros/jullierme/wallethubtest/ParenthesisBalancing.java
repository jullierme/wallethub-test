package com.barros.jullierme.wallethubtest;

import java.util.ArrayDeque;
import java.util.Deque;

public class ParenthesisBalancing {
    static boolean isMatching(char character1, char character2) {
        if (character1 == '(' && character2 == ')')
            return true;
        else if (character1 == '{' && character2 == '}')
            return true;
        else return character1 == '[' && character2 == ']';
    }

    static boolean parensMatch(String value) {
        if(value == null || value.isEmpty())
            return true;

        Deque<Character> st = new ArrayDeque<>();

        for (char c : value.toCharArray()) {
            if (c == '{' || c == '(' || c == '[')
                st.push(c);
            if (c == '}' || c == ')' || c == ']') {
                if (st.isEmpty()) {
                    return false;
                }
                else if (!isMatching(st.pop(), c)) {
                    return false;
                }
            }

        }

        return st.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println("(a[0]+b[2c[6]]) {24 + 53}  passed:" + parensMatch("(a[0]+b[2c[6]]) {24 + 53}"));
        System.out.println("f(e(d))                    passed:" + parensMatch("f(e(d))"));
        System.out.println("[()]{}([])                 passed:" + parensMatch("[()]{}([])"));
        System.out.println("((b)                       passed:" + !parensMatch("((b)"));
        System.out.println("(c]                        passed:" + !parensMatch("(c]"));
        System.out.println("{(a[])                     passed:" + !parensMatch("{(a[])"));
        System.out.println("([)]                       passed:" + !parensMatch("([)]"));
        System.out.println(")(                         passed:" + !parensMatch(")("));
        System.out.println(" (empty)                   passed:" + parensMatch(""));
    }
}
