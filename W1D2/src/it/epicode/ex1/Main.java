package it.epicode.ex1;

public class Main {

    // Stringa pari o dispari?
    public static boolean isStringEvenOrOdd(String inputString) {
        return inputString.length() % 2 == 0;
    }

    // E' un anno bisestile?
    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0));
    }

    public static void main(String[] args) {
        System.out.println("Is 'hello' even length? " + isStringEvenOrOdd("hello"));
        System.out.println("Is 'world!' even length? " + isStringEvenOrOdd("world!"));

        System.out.println("Is 2020 a leap year? " + isLeapYear(2020));
        System.out.println("Is 1900 a leap year? " + isLeapYear(1900));
    }

}
