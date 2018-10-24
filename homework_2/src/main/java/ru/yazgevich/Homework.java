package ru.yazgevich;

/**
 * @author Yazgevich Anton
 */

import java.util.Arrays;

public class Homework {
    public static void main(String[] args) {
        System.out.println("Good day,Sensei!!!");
        System.out.println("");
        final int n = -2;
        byte[] arrBin = {1, 0, 0, 1, 0, 1, 1};
        int[] casArr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        int[][] squareArr = new int[9][9];
        int[] equalArr = new int[(int)(Math.random() * 4 + 3)];
        for (int i = 0;i < equalArr.length;i++)
            equalArr[i] = (int)(Math.random() * 3);

        changeValue(arrBin);
        System.out.println("");
        fillArr();
        System.out.println("");
        multiplyArr(casArr);
        System.out.println("");
        fillDiagonal(squareArr);
        System.out.println("");
        getExtremeValue();
        System.out.println("");
        System.out.println(isEqualArr(equalArr));
        System.out.println("");
        shiftValueArr(equalArr,n);

    }

    public static void changeValue(byte[] arrBin){
        System.out.println(Arrays.toString(arrBin));
        for (int i = 0; i < arrBin.length; i++){
            if (arrBin[i] == 0) {
                arrBin[i] = 1;
            } else arrBin[i] = 0;
        }
        System.out.println(Arrays.toString(arrBin));
    }

    public static void fillArr(){
        int[] emptyArr = new int[8];
        for(int i = 0,o = 0;i < emptyArr.length;i++,o += 3){
            emptyArr[i] = o;
            System.out.println(i + " - " + emptyArr[i]);
        }
    }

    public static void multiplyArr(int[] casArr){

        System.out.println(Arrays.toString(casArr));
        for(int i = 0;i<casArr.length;i++){
            if (casArr[i]<6)
                casArr[i] *= 2;
        }
        System.out.println(Arrays.toString(casArr));
    }

    public static void fillDiagonal(int[][] squareArr){
        int y = squareArr.length - 1;
        int x = 0;
        for(int i = 0;i < squareArr.length;i++) {
            for (int j = 0; j < squareArr[i].length; j++){
                squareArr[i][j] = 8;
                if (i == j)
                    squareArr[i][j] = 1;
            }
            squareArr[x][y] = 1;
            y--;
            x++;
            System.out.println(Arrays.toString(squareArr[i]));
        }
    }

    public static void getExtremeValue(){
        int[] extArr = new int[9];
        int min = 9999,max = -9999,i;
        for(i = 0;i < extArr.length;i++)
            extArr[i] = (int)(Math.random() * 25);
        System.out.println(Arrays.toString(extArr));
        System.out.println("");
        for (i = 1;i < extArr.length;i++){
            if(extArr[i] > max) max = extArr[i];
            if(extArr[i] < min) min = extArr[i];
        }
        System.out.println("min = " + min);
        System.out.println("max = " + max);
    }

    public static boolean isEqualArr(int[] equalArr) {
        System.out.println(Arrays.toString(equalArr));
        int left = 0, right = 0;
        int half = equalArr.length / 2;
        boolean yes = true;
        boolean no = false;
        for (int i = 0; i < half; i++)
            left += equalArr[i];
        for (int i = half; i < equalArr.length; i++)
            right += equalArr[i];
        if (left == right) return yes;
        else return no;
    }

    public static void shiftValueArr(int[] equalArr,int n){
        int i = 0,j = 1;
        int[] cloneArr = Arrays.copyOf(equalArr,equalArr.length);
        if (n > 0) {
            for (int v : cloneArr) {
                int delta = (i + n) - equalArr.length;
                if (delta < 0) delta = 0;
                if (i + n < equalArr.length)
                    equalArr[i + n] = v;
                else equalArr[delta] = v;
                i++;
            }
        }else {
            for (j = equalArr.length - 1;j >= 0;j--){
                if (j + n >= 0){
                    equalArr[j + n] = cloneArr [j];
                }else {
                    equalArr[equalArr.length + j + n] = cloneArr[j];
                }
            }
        }
        System.out.println(Arrays.toString(equalArr));
    }
}