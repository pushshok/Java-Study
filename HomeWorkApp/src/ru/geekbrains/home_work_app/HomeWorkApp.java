package ru.geekbrains.home_work_app;

public class HomeWorkApp {

    public static void main(String[] args) {
        printThreeWords();
        checkSumSign();
        printColor();
        compareNumbers();
    }

    public static void printThreeWords() {
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");

    }

    public static void checkSumSign() {
        int a, b;
        a = 10;
        b = 5;
        System.out.println("Sum " + ((a + b >= 0) ? "is positive." : "is negative"));
    }

    public static void printColor() {
        int value;
        value = 100;
        if (value <= 0) {
            System.out.println("Red");
        } else if ((value > 0) && (value <= 100)) {
            System.out.println("Yellow");
        } else {
            System.out.println("Green");
        }
    }

    public static void compareNumbers() {
        int a, b;
        a = 10;
        b = 15;
        System.out.println(a >= b ? "a >= b" : "a < b");
    }

}
