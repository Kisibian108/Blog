package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println(" in put the moment number");
        int size = Integer.parseInt(scanner.nextLine());
        System.out.println(" in put the numbers");
        int[] numberList = new int[size];
        for (int i = 0; i < size; i++) {
            numberList[i] = Integer.parseInt(scanner.nextLine());
        }
        int max = 0;
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (numberList[i] > max) {
                max = numberList[i];
                count++;
            }
        }

        int a = 0;
        for (int i = 0; i < count - 1; i++) {
            a += numberList[i];
        }

        int b = 0;
        for (int i = count; i < numberList.length; i++) {
            b += numberList[i];
        }
        if (a == b) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
}