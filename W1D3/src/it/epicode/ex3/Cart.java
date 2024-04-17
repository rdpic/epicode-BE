package it.epicode.ex3;

public class Cart {

    private Customer associatedCustomer;
    private Article[] articles;
    private int articleCount;
    private double totalCost;

    public Cart(Customer associatedCustomer) {
        this.associatedCustomer = associatedCustomer;
        this.articles = new Article[10];
        this.articleCount = 0;
        this.totalCost = 0.0;
    }

    public void addArticle(Article article) {
        if (articleCount < articles.length) {
            articles[articleCount] = article;
            articleCount++;
            totalCost += article.getPrice();
        } else {
            System.out.println("Cart is full. Cannot add more articles.");
        }
    }

    public double getTotalCost() {
        return totalCost;
    }

    @Override
    public String toString() {
        StringBuilder cartContents = new StringBuilder();
        cartContents.append("Cart for ").append(associatedCustomer).append(":\n");
        for (int i = 0; i < articleCount; i++) {
            cartContents.append(articles[i]).append("\n");
        }
        cartContents.append("Total Cost: €").append(totalCost);
        return cartContents.toString();
    }

}
