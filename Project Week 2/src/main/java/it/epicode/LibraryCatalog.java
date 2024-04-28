package it.epicode;

import it.epicode.Book;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class LibraryCatalog {
    List<CatalogItem> items;

    public LibraryCatalog() {
        this.items = new ArrayList<>();
    }

    public void addItem(CatalogItem item) {
        this.items.add(item);
        System.out.println("Successfully added product to catalog. ISBN: " + item.getIsbn());
    }

    public void removeItemByISBN(String isbn) throws Exception {
        if (items.removeIf(item -> item.getIsbn().equals(isbn))) {
            System.out.println("Successfully removed product fom catalog. ISBN: " + isbn);
        } else {
            throw new Exception("Product not found in catalog. ISBN: " + isbn);
        }
    }

    public List<CatalogItem> searchByISBN(String isbn) {
        return items.stream()
                .filter(item -> item.getIsbn().equals(isbn))
                .collect(Collectors.toList());
    }

    public List<CatalogItem> searchByPublicationYear(int year) {
        return items.stream()
                .filter(item -> item.getPublicationYear() == year)
                .collect(Collectors.toList());
    }

    public List<Book> searchByAuthor(String author) {
        return items.stream()
                .filter(item -> item instanceof Book && ((Book) item).getAuthor().equals(author))
                .map(item -> (Book) item)
                .collect(Collectors.toList());
    }

    public void saveCatalogToFile(String filePath) throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filePath))) {
            out.writeObject(items);
        }
    }

    @SuppressWarnings("unchecked")
    public void loadCatalogFromFile(String filePath) throws IOException, ClassNotFoundException {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filePath))) {
            items = (List<CatalogItem>) in.readObject();
        }
    }
}
