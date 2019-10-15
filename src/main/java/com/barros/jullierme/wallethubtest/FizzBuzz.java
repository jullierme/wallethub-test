package com.barros.jullierme.wallethubtest;

import java.util.Optional;
import java.util.stream.IntStream;

public class FizzBuzz {

    private static void printFizzBuzz(int start, int end) {
        IntStream.rangeClosed(start, end).boxed()
                .map(value -> (value % 3 == 0 ? "Fizz" : "") +
                        (value % 5 == 0 ? "Buzz" : (value % 3 == 0 ? "" : value)))
                .forEach(System.out::println);

    }

    private static String printFizzBuzz(int number) {
        return Optional.of(number)
                .map(value -> (value % 3 == 0 ? "Fizz" : "") + (value % 5 == 0 ? "Buzz" : ""))
                .map(value -> (value.isEmpty() ? String.valueOf(number) : value) + " ")
                .orElse("");

    }

    private static void fizzBuzz() {
        for (int x = 0; x < 100; x++) {
            System.out.print(printFizzBuzz(x));
        }
    }

    public static void main(String[] args) {
        //fizzBuzz();
        printFizzBuzz(0, 100);
    }
}
