package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj długość krawędzi sześcianu: ");
        double a = scanner.nextDouble();

        System.out.println("Objętość wynosi: " + a*a*a);
    }
}
