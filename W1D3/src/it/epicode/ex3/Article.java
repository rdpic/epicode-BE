package it.epicode.ex3;

public class Article {

    private String code;
    private String description;
    private double price;
    private int stockQuantity;

    public Article(String code, String description, double price, int stockQuantity) {
        this.code = code;
        this.description = description;
        this.price = price;
        this.stockQuantity = stockQuantity;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public String toString() {
        return code + " - " + description + ", €" + price;
    }

}
