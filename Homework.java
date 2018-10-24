package ru.yazgevich.se;

/**
 * @author Anton Yazgevich
 * Домашнее задание к уроку номер 1 курса "Java.уровень 1"
 */
                                                // task 1
public class Homework {
    public static void main(String[] args) {
                                                //task 2
        byte m = 4;
        short n = 6;
        int a = 6;
        int b = 6;
        int c = 8;
        int d = 4;
        long d1 = 4L;
        float e = 4.0f;
        double f = 16.3463;
        boolean g = true;
        char h = 'x';
        int year = 1200;
        String name = "Денис";
        System.out.println(task3(a,b,c,d));    //task 3
        System.out.println(task4(m, c));       //task 4
        task5(c);                              //task 5
        System.out.println(task6(c));          //task 6
        task7(name);                           //task 7
        task8(year);                           //task 8
    }

    static int task3(int a,int b, int c, int d) {
        return a * (b + (c / d));
    }

    static String task4(byte m, int c) {
        if (m + c >= 10 && m + c <= 20)
            return "True";
        else
            return "False";
    }

    public static void task5(int c) {
        if (c >= 0) System.out.println("Переданное число положительное");
        else System.out.println("Переданное число отрицательное");
    }

    static String task6(int c) {
        if (c < 0)
            return "True";
        else return "";

    }

    public static void task7(String name){
        System.out.println("Привет, " + name + "!");
    }

    public static void task8(int year){
        boolean left = year % 4 == 0 && (year % 100 != 0 || year % 400 == 0);
        if (left){
            System.out.println(year + " год високосный");
        }else
            System.out.println(year + " год НЕ високосный");
    }

}
