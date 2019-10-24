package com.barros.jullierme.wallethubtest;

import java.util.Optional;
import java.util.stream.IntStream;

public class FizzBuzz {

    private static void printFizzBuzz(int start, int end) {
        IntStream.rangeClosed(start, end).boxed()
                .map(FizzBuzz::printFizzBuzz)
                .forEach(System.out::println);

    }

    private static String printFizzBuzz(int number) {
        String result = (number % 3 == 0 ? "Fizz" : "") + (number % 5 == 0 ? "Buzz" : "");
        return result.isEmpty() ? Integer.toString(number) : result;
    }

    private static void fizzBuzz() {
        for (int x = 1; x <= 100; x++) {
            System.out.print(printFizzBuzz(x));
        }
    }

    private static void fizzBuzz2() {
        for (int x = 1; x <= 100; x++) {
            String result = (x % 3 == 0 ? "Fizz" : "") + (x % 5 == 0 ? "Buzz" : "");
            System.out.println(result.isEmpty() ? Integer.toString(x) : result);
        }
    }

    public static void main(String[] args) {
        System.out.println("asdfasdfasdfsadfsadf");
        //\u000d System.out.println("asdfasdf");
    }
}
