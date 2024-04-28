package it.epicode;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws Exception {
        LibraryCatalog catalog = new LibraryCatalog();

        Book book1 = new Book("123-456-789", "The Art of Programming", 2020, 300, "Donald Knuth", "Computer Science");
        Book book2 = new Book("321-654-987", "Clean Code", 2008, 464, "Robert C. Martin", "Software Engineering");
        Magazine magazine1 = new Magazine("987-654-321", "Tech Today", 2021, 40, Magazine.Periodicity.MONTHLY);

        catalog.addItem(book1);
        catalog.addItem(book2);
        catalog.addItem(magazine1);

        System.out.println("--------------------------------");

        catalog.searchByISBN("123-456-789").forEach(item -> System.out.println("Found by ISBN: " + item.getTitle()));

        catalog.searchByPublicationYear(2020).forEach(item -> System.out.println("Found by Year: " + item.getTitle()));

        catalog.searchByAuthor("Donald Knuth").forEach(book -> System.out.println("Found by Author: " + book.getTitle()));

        System.out.println("--------------------------------");
        System.out.println("Removing product...");

        try {
            catalog.removeItemByISBN("123-456-789");
        } catch (Exception e) {
            e.printStackTrace();
        }

        String filePath = "catalog.txt";
        try {
            catalog.saveCatalogToFile(filePath);
            System.out.println("--------------------------------");
            System.out.println("Catalog saved to file.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        catalog.items.clear();

        try {
            catalog.loadCatalogFromFile(filePath);
            System.out.println("--------------------------------");
            System.out.println("Catalog loaded from file with " + catalog.items.size() + " items.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        catalog.items.forEach(item -> System.out.println("Item in catalog: " + item.getTitle()));
    }
}
