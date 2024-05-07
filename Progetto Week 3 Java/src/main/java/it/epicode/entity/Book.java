package it.epicode.entity;

import javax.persistence.*;

@Entity
@Table(name = "books")
public class Book extends CatalogItem {
    private String author;
    private String genre;

    public Book() {}

    public Book(String isbn, String title, int publicationYear, int pageCount, String author, String genre) {
        super(isbn, title, publicationYear, pageCount);
        this.author = author;
        this.genre = genre;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}