package it.epicode.ex1;

import static it.epicode.ex1.Rectangle.printTwoRectangles;

public class Main {

    public static void main(String[] args) {
        Rectangle rectangle1 = new Rectangle(4, 3);
        Rectangle rectangle2 = new Rectangle(5, 2);
        printTwoRectangles(rectangle1, rectangle2);
    }

}
