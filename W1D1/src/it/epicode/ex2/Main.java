package it.epicode.ex2;

import java.util.Scanner;

public class Main {

    public static void concatStrings() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the first string:");
        String str1 = scanner.nextLine();

        System.out.println("Enter the second string:");
        String str2 = scanner.nextLine();

        System.out.println("Enter the third string:");
        String str3 = scanner.nextLine();

        String concatInOrder = str1 + str2 + str3;
        String concatReverseOrder = str3 + str2 + str1;
        System.out.println("Concatenated in order: " + concatInOrder);
        System.out.println("Concatenated in reverse order: " + concatReverseOrder);

        scanner.close();
    }

    public static void main(String[] args) {
        concatStrings();
    }

}
