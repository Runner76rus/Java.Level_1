package ru.yazgevich.se;

import java.util.Arrays;

public class AiTurn extends GameXO {
    public static void aiTurn() {
        if (checkHumanTurn(DOT_X)) {
            blockHumanTurnLine();
        } else {
            toRandomTurn();
        }
    }

    public static void toRandomTurn(){
        int x, y;
        do {
            x = random.nextInt(SIZE);
            y = random.nextInt(SIZE);
        } while (!isCellValid(x, y));
        System.out.println("Компьютер сходил в точку " + (x + 1) + " " + (y + 1));
        map[x][y] = DOT_O;
    }

    public static boolean checkHumanTurn(char symb) {
        for (int line = 0; line < SIZE - BLOCK + 2; line++) {
            for (int col = 0; col < SIZE - BLOCK + 2; col++) {
                if (checkHumanTurnLine(symb, line, col) || checkHumanTurnDiagonal(symb, line, col))
                    return true;
            }
        }
        return false;
    }

    private static boolean checkHumanTurnLine(char symb, int offSetX, int offSetY) {
        for (int line = offSetX; line < (BLOCK - 1) + offSetX; line++) {
            boolean horiz = true;
            boolean vert = true;
            for (int col = offSetY; col < (BLOCK - 1) + offSetY; col++) {
                vert &= map[line][col] == symb;
                horiz &= map[col][line] == symb;
            }
            if (vert || horiz) return true;
        }
        return false;
    }

    public static void blockHumanTurnLine(){
        char[][] cloneMap = map.clone();
        for (int i = 0;i < map.length;i++){
            cloneMap[i] = map[i].clone();
        }
        for (int line = 0;line < SIZE - BLOCK  + 2;line++){
            for(int col = 0;col < SIZE - BLOCK + 2;col++){
                humanTurnLine(cloneMap,line,col);
            }
        }
    }

    public static void humanTurnLine(char[][] cloneMap,int offSetX,int offSetY) {
        for (int line = offSetX; line < BLOCK - 1 + offSetX; line++) {
            boolean horiz = true;
            boolean vert = true;
            int col;
            for (col = offSetY; col < BLOCK - 1 + offSetY; col++) {
                horiz &= map[line][col] == DOT_X;
                vert &= map[col][line] == DOT_X;
            }
            if (horiz) {
                for (int i = 0; i < SIZE; i++) {
                    if (map[line][i] == DOT_EMPTY) {
                        map[line][i] = DOT_O;
                        break;
                    }
                }
            }
            if (vert) {
                for (int i = 0; i < SIZE; i++) {
                    if (map[i][line] == DOT_EMPTY) {
                        map[i][line] = DOT_O;
                        break;
                    }
                }
            }
        }
        if (Arrays.deepEquals(map,cloneMap)) toRandomTurn();
    }

    public static boolean checkHumanTurnDiagonal(char symb, int offSetX, int offSetY) {
        boolean toLeft = true;
        boolean toRight = true;
        for (int i = 0; i < BLOCK - 1; i++) {
            toRight &= map[i + offSetX][i + offSetY] == symb;
            toLeft &= map[BLOCK - i - 2 + offSetX][i + offSetY] == symb;
        }
        if (toRight || toLeft) return true;
        return false;
    }

}
