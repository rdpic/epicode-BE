package it.epicode.ex2;

public class Main {

    public static void main(String[] args) {
        SIM simCard = new SIM("3497767604");
        simCard.addCall(new Call(2, "0987654321"));
        simCard.addCall(new Call(3, "0123456789"));
        simCard.addCall(new Call(1, "3409421769"));
        simCard.addCall(new Call(5, "3396659831"));
        simCard.addCall(new Call(7, "0774570297"));
        simCard.addCall(new Call(6, "0695669590"));
        simCard.printSIMData();
    }

}
