package it.epicode.ex1;

public class Main {

    public static int mult(int num1, int num2) {
        return num1 * num2;
    }

    public static String concat(String str, int num) {
        return str + num;
    }

    public static String[] pushToArray(String[] array, String str) {
        String[] newArray = new String[6];
        for (int i = 0; i < 2; i++) {
            newArray[i] = array[i];
        }

        newArray[2] = str;

        for (int i = 3; i < 6; i++) {
            newArray[i] = array[i - 1];
        }
        return newArray;
    }

    public static void main(String[] args) {
        int product = mult(3, 4);
        System.out.println("The product is: " + product);

        String concatenatedString = concat("Hello ", 5);
        System.out.println("The concatenated string is: " + concatenatedString);

        String[] initialArray = {"one", "two", "three", "four", "five"};
        String[] resultArray = pushToArray(initialArray, "inserted");

        System.out.print("The new array is: ");

        for (String s : resultArray) {
            System.out.print(s + " ");
        }
    }

}
