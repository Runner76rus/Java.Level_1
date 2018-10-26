package ru.yazgevich.homework;

import java.util.Scanner;

public class NumberGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введи своё имя");
        String name = scanner.nextLine();
        System.out.println("Привет, " + name + " ! =)");
        int choice;
        do {
            System.out.println("Тебе нужно угадать число от 0 до 9");
            System.out.println("У тебя есть всего 3 попытки!");
            System.out.println("Введи число");
            int x = (int) (Math.random() * 9);
            int enter = 0;
            for (int i = 0; i < 3; i++) {
                enter = scanner.nextInt();
                if (enter == x) {
                    System.out.println("Правильно :) Возьми с полки пирожок");
                    break;
                } else if (enter < x) System.out.println("Загаданное число больше");
                else System.out.println("Загаданное число меньше");
            }
            if (enter != x) System.out.println("Увы,но все попытки закончились :(");
            System.out.println("Повторить игру еще раз? 1 – да / 0 – нет");
            choice = scanner.nextInt();
            while (choice < 0 && choice > 1) {
                System.out.println("Не балуй!Либо 1, либо 0!");
            }
        } while (choice == 1);
    }
}
