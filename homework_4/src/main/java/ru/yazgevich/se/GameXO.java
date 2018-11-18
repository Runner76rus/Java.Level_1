package ru.yazgevich.se;

import java.util.Random;
import java.util.Scanner;

public class GameXO {

    public static final char DOT_EMPTY = '.';

    public static final char DOT_X = 'X';

    public static final char DOT_O = 'O';

    public static final int SIZE = 5;

    public static final int BLOCK = 4;

    private static Scanner sc = new Scanner(System.in);

    public static char[][] map;

    public static Random random = new Random();

    public static void main(String[] args) {
        initMap();
        printMap();
        goGame();

    }

    public static void initMap() {
        map = new char[SIZE][SIZE];
        for (int line = 0; line < SIZE; line++) {
            for (int col = 0; col < SIZE; col++) {
                map[line][col] = '.';
            }
        }
    }

    public static void printMap() {
        for (int line = 0; line <= SIZE; line++) {
            System.out.print(line + " ");
        }
        System.out.println();
        for (int line = 0; line < SIZE; line++) {
            System.out.print((line + 1) + " ");
            for (int col = 0; col < SIZE; col++) {
                System.out.print(map[line][col] + " ");
            }
            System.out.println();
        }
    }

    private static void humanTurn() {
        int x, y;
        do {
            System.out.println("Введите координаты оси Х и Y");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (!isCellValid(x, y));
        map[x][y] = DOT_X;
    }

    public static boolean isCellValid(int x, int y) {
        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) return false;
        if (map[x][y] == DOT_EMPTY) return true;
        return false;
    }

    private static boolean checkWin(char symb) {
        for (int line = 0; line < SIZE - BLOCK + 1; line++) {
            for (int col = 0; col < SIZE - BLOCK + 1; col++) {
                if (checkWinLine(symb, line, col) || checkWinDiagonal(symb, line, col)) return true;
            }
        }
        return false;
    }

    private static boolean checkWinLine(char symb, int offSetX, int offSetY) {
        for (int line = offSetX; line < BLOCK + offSetX; line++) {
            boolean horiz = true;
            boolean vert = true;
            for (int col = offSetY; col < BLOCK + offSetY; col++) {
                vert &= map[line][col] == symb;
                horiz &= map[col][line] == symb;
            }
            if (vert || horiz) return true;
        }
        return false;
    }

    private static boolean checkWinDiagonal(char symb, int offSetX, int offSetY) {
        boolean toLeft = true;
        boolean toRight = true;
        for (int i = 0; i < BLOCK; i++) {
            toRight &= map[i + offSetX][i + offSetY] == symb;
            toLeft &= map[BLOCK - i - 1 + offSetX][i + offSetY] == symb;
        }
        if (toRight || toLeft) return true;
        return false;
    }

    private static boolean isMapFull() {
        for (int line = 0; line < SIZE; line++) {
            for (int col = 0; col < SIZE; col++) {
                if (map[line][col] == DOT_EMPTY) return false;
            }
        }
        return true;
    }

    private static void goGame() {
        while (true) {
            humanTurn();
            printMap();
            if (checkWin(DOT_X)) {
                System.out.println("Победил человек!!!");
                break;
            }
            if (isMapFull()) {
                System.out.println("НИЧЬЯ!");
                break;
            }
            AiTurn.aiTurn();
            printMap();
            if (checkWin(DOT_O)) {
                System.out.println("Победил кампуктер!!!");
                break;
            }
            if (isMapFull()) {
                System.out.println("НИЧЬЯ!");
                break;
            }
        }
        System.out.println("Конец игры!!!");
    }
}
