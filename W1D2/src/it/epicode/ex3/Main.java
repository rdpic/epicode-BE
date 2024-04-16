package it.epicode.ex3;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter a string (type ':q' to quit): ");
            String inputString = scanner.nextLine();

            if (":q".equals(inputString)) {
                System.out.print("Exiting program...");
                break;
            } else {
                System.out.println(String.join(",", inputString.split("")));
            }
        }

        scanner.close();
    }

}
