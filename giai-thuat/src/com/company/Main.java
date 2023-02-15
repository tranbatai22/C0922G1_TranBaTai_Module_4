package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        System.out.println("Nhập chiều cao của tam giác: ");
        n = Integer.parseInt(sc.nextLine());
        System.out.println("*");
        for (int i = 0; i < n - 1; i++) {
            System.out.print("*");
            for (int j = 0; j <= i; j++) {
                System.out.print("  ");
            }
            System.out.println("*");
        }
        for (int i = n - 1; i >= 0; i--) {
            System.out.print("*");
            for (int j = i; j >= 0; j--) {
                System.out.print("  ");
            }
            System.out.println("*");
        }
        System.out.println("*");
    }
}
