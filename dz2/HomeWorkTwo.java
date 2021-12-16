/**
 * Java 1. Homework #2.
 * @author Zdibnyak Maxim
 * @version 12.12.2021
 */

package ru.geekbrains.home_work_app;

public class HomeWorkTwo {

    public static void main(String[] args) {
        twoNumber(10, 5);
        positiveOrNegative(-5);
        negativeOrPositive(0);
        repeatString("It is a string.", 10);
        leapYear(400);
    }

    static boolean twoNumber (int a, int b) { return (a + b >= 10) || (a + b <= 20) ? true : false; }

    static void positiveOrNegative(int a) { System.out.println(a >= 0 ? "Number is positive." : "Number is negative."); }

    static boolean negativeOrPositive(int b) { return b < 0 ? true : false; }

    static void repeatString(String forString, int a) { for (int i = 0; i < 10; i++) { System.out.println(forString); } }

    static boolean leapYear(int c) { return (((c % 4 == 0) && (c % 100 != 0)) || (c % 400 == 0)) ? true : false ; }

}

