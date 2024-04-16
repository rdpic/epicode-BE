package it.epicode.ex4;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an integer to count down from: ");
        int startNumber = scanner.nextInt();

        for (int number = startNumber; number >= 0; number--) {
            System.out.println(number);
        }

        scanner.close();
    }

}
