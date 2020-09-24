package com.arslan;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Example {
    public static void main(String[] args) {
        try {
            int result = divide();
            System.out.println(result);
        } catch (ArithmeticException | NoSuchElementException e) {
            System.out.println(e.toString());
            System.out.println("Unable to perform division");
        }

    }

    private static int divide() {
        int x, y;
        x = getInt();
        y = getInt();
        System.out.println("x is " + x + ", y is " + y);
        return x / y;
    }

    private static int getInt() {
        Scanner s = new Scanner(System.in);
        System.out.println("Please enter an integer ");
        while (true) {
            try {
                return s.nextInt();
            } catch (NoSuchElementException e) {
                // read past the end of line in the input first.
                s.nextLine();
                System.out.println("Please enter valid integer using only digits 0 to 9");
            }
        }
    }
}

