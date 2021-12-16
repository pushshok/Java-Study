/**
 * Java 1. Homework #3.
 * @author Zdibnyak Maxim
 * @version 13.12.2021
 */
package ru.geekbrains.home_work_app;
import java.util.Arrays;
import java.util.Scanner;

public class HomeWorkThree {

    public static void main(String[] args) {
        int [] arr = {0, 3, 1, 1, 0, 0, 0, 0, 5};

	    inverseArray();
        emptyArray();
        multiplyArray();
        twoDimensionalArray();
        lengthArray(10, 3);
        minAndMax();
        System.out.println(leftAndRight(arr) + "\n");
        swingArray(arr, 2);
    }

    static void inverseArray() {
        int [] arr = {1, 1, 0, 1, 0, 0, 1, 1, 0, 0};
        System.out.println("Array #1: " + Arrays.toString(arr));

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                arr[i] = 1;
            } else {
                arr[i] = 0;
            }
        }

        System.out.println("Resulting array #1: " + Arrays.toString(arr));
        System.out.print("\n");
    }

    static void emptyArray() {
        int [] arr = new int[100];
        System.out.print("Array #2: ");
        for (int i = 0; i < 100; i++) {
            arr[i] = i + 1;
            System.out.print(arr[i] + " ");
        }
        System.out.print("\n\n");
    }

    static void multiplyArray() {
        int [] arr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println("Array #3:" + Arrays.toString(arr));

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 6) arr[i] = arr[i] * 2;
        }

        System.out.println("Resulting array #3:" + Arrays.toString(arr));
        System.out.print("\n");
    }

    static void twoDimensionalArray() {
        int [][] arr = new int[5][5];
        System.out.println("Array #4:");
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if (i == j) arr[i][j] = 1;
                    if (i == 4 - j) arr[i][j] = 1;
                    System.out.print(arr[i][j] + " ");
                }
                System.out.println();
            }
        System.out.print("\n");
    }

    static void lengthArray(int len, int initialValue) {
        int [] arr = new int[len];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = initialValue;
        }
        System.out.println("Array #5:" + Arrays.toString(arr) + "\n\n");
    }

    static void minAndMax() {
        System.out.println("Enter size of the array:");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int [] arr = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Enter the number:");
            arr[i] = scanner.nextInt();
        }
        System.out.println("Your array: " + Arrays.toString(arr));

        int max = arr[0], min = arr[0];
        for (int i = 0; i < n; i++) {
            if (arr[i] > max) max = arr[i];
            if (arr[i] < min) min = arr[i];
        }
        System.out.println("Max number is: " + max + "; Min number is: " + min + "\n\n");
    }

    static boolean leftAndRight(int [] arr) {
        System.out.println("Default array #7: " + Arrays.toString(arr));
        int left = 0, right = 0;
        for (int i = 0, e = arr.length - 1; i <= e; i++, e--) {

            left = left + arr[i];
            right = right + arr[e];
            System.out.println("Sum left: " + left + "; Sum right: " + right);
            if ((i == e) && (left == right)) {
                return(true);
            }

        }
        return false;
    }

    static void swingArray(int[] arr, int shift) {
        System.out.println("Default array #8: " + Arrays.toString(arr));

        if (shift > 0) {
            for (int j = 0; j < shift; j++) {
                int exChange = 0;
                for (int i = 0; i < arr.length; i++) {
                    if (i == 0) exChange = arr[0];
                    if (i + 1 < arr.length) {
                        arr[i] = arr[i + 1];
                    } else arr[i] = exChange;
                }
            }
        } else if (shift < 0) {
            for (int j = 0; j < Math.abs(shift); j++) {
                int exChange = 0;
                for (int i = arr.length - 1; i >= 0; i--) {
                    if (i == arr.length - 1) exChange = arr[arr.length - 1];
                    if (i >= 1) {
                        arr[i] = arr[i - 1];
                    } else arr[i] = exChange;
                }
            }
        } else System.out.println("Shift not allow!");

        System.out.println("Resulting array #8: " + Arrays.toString(arr));
    }
}
