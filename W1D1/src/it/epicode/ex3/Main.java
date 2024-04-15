package it.epicode.ex3;

import java.util.Scanner;

public class Main {

    public static double rectanglePerimeterCalc(double sideA, double sideB) {
        return 2 * (sideA + sideB);
    }

    public static int evenOddCalc(int number) {
        return number % 2;
    }

    public static double triangleAreaCalc(double sideA, double sideB, double sideC) {
        double semiPerimeter = (sideA + sideB + sideC) / 2;
        return Math.sqrt(semiPerimeter * (semiPerimeter - sideA) * (semiPerimeter - sideB) * (semiPerimeter - sideC));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Perimetro rettangolo
        System.out.println("--- Rectangle Perimeter ---");
        System.out.println("Enter the lengths of the two sides of the rectangle:");
        double sideA = scanner.nextDouble();
        double sideB = scanner.nextDouble();
        System.out.println("Perimeter of the rectangle: " + rectanglePerimeterCalc(sideA, sideB));

        // Pari o dispari?
        System.out.println();
        System.out.println("--- Even or Odd? ---");
        System.out.println("Enter an integer:");
        int number = scanner.nextInt();
        System.out.println("The number is " + (evenOddCalc(number) == 0 ? "even" : "odd"));

        // Area triangolo
        System.out.println();
        System.out.println("--- Triangle Area ---");
        System.out.println("Enter the lengths of the three sides of the triangle:");
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();
        System.out.println("Area of the triangle: " + triangleAreaCalc(a, b, c));

        scanner.close();
    }

}
