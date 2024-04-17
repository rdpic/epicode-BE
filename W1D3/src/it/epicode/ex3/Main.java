package it.epicode.ex3;

public class Main {

    public static void main(String[] args) {
        Customer customer = new Customer("R1", "Riccardo Del Piccolo", "riccardodelpiccolo@epicode.com");
        Article article1 = new Article("A456", "Laptop", 999.99, 10);
        Article article2 = new Article("A789", "Smartphone", 499.99, 20);

        Cart cart = new Cart(customer);
        cart.addArticle(article1);
        cart.addArticle(article2);

        System.out.println(cart);
    }

}
