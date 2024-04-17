package it.epicode.ex1;

public class Rectangle {

    private double height;
    private double width;

    public Rectangle(double height, double width) {
        this.height = height;
        this.width = width;
    }

    public double calcArea() {
        return height * width;
    }

    public double calcPerimeter() {
        return 2 * (height + width);
    }

    public static void printRectangle(Rectangle rectangle) {
        System.out.println("Area: " + rectangle.calcArea() + ", Perimetro: " + rectangle.calcPerimeter());
    }

    public static void printTwoRectangles(Rectangle rectangle1, Rectangle rectangle2) {
        printRectangle(rectangle1);
        printRectangle(rectangle2);
        double totalArea = rectangle1.calcArea() + rectangle2.calcArea();
        double totalPerimeter = rectangle1.calcPerimeter() + rectangle2.calcPerimeter();
        System.out.println("Area Totale: " + totalArea + ", Perimetro Totale: " + totalPerimeter);
    }

}
