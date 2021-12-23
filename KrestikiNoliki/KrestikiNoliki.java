package ru.geekbrains.home_work_app;
import java.util.Scanner;
import java.util.Random;

public class KrestikiNoliki {

    // Для класса Char одинарные кавычки
    final char SIGN_X = 'x';
    final char SIGN_O = 'o';
    final char SIGN_EMPTY = '.';
    char[][] table;
    Scanner sc;
    Random random;

    public static void main(String[] args) {
        KrestikiNoliki ref = new KrestikiNoliki();
        ref.game();
        // new TicTacToe().game();
    }

    KrestikiNoliki() {
        table = new char[3][3];
        sc = new Scanner(System.in);
        random = new Random();
    }

    void game() {
        // System.out.println("game");
        initTable();
        printTable();
        while (true) {
            turnHuman();
            if (isWin(SIGN_X)) {
                System.out.println("YOU WIN!");
                break;
            }
            if (isTableFull()) {
                System.out.println("DRAW!");
                break;
            }
            turnAi();
//            printTable();
            if (isWin(SIGN_O)) {
                System.out.println("AI WIN!");
                break;
            }
            if (isTableFull()) {
                System.out.println("DRAW!");
                break;
            }
            printTable();
        }
    }

    void initTable() {
        for (int y = 0; y < table.length; y++) {
            for (int x = 0; x < table.length; x++) {
                table[y][x] = SIGN_EMPTY;
            }
        }
    }

    void printTable() {
        for (int y = 0; y < table.length; y++) {
            for (int x = 0; x < table.length; x++) {
                System.out.print(table[y][x] + " ");
            }
            System.out.println();
        }
    }

    void turnHuman() {
        int x, y;
        do {
            System.out.println("Enter X Y");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (!isCellValid(x, y));
        table[y][x] = SIGN_X;
    }

    void turnAi() {
        int x, y;
        do {
            System.out.println("Enter X Y");
            x = random.nextInt(3);
            y = random.nextInt(3);
        } while (!isCellValid(x, y));
        table[y][x] = SIGN_O;
    }

    boolean isCellValid (int x, int y) {
        if (x < 0 || x > 2 || y < 0 || y > 2) {
            return false;
        }
        return table[y][x] == SIGN_EMPTY;
    }

    boolean isWin(char ch) {
        //        Победа для диагоналей
        if(table[0][0] == ch && table[1][1] == ch && table[2][2] == ch) return true;
        if(table[2][0] == ch && table[1][1] == ch && table[0][2] == ch) return true;

        //        Проверка увловия победы в цикле
        for (int i = 0, j = 0; i < table.length; i++) {
            if ((i <= 2) && (j <= 2)) {
                if (table[i][j] == ch && table[i][j + 1] == ch && table[i][j + 2] == ch) return true;
            }
        }
        return false;
    }

    boolean isTableFull() {
        for (int y = 0; y < table.length; y++) {
            for (int x = 0; x < table.length; x++) {
                if(table[y][x] == SIGN_EMPTY) {
                    return  false;
                }
            }
        }
        return true;
    }
}
