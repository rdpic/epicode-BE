package it.epicode;

import java.io.Serializable;

public abstract class CatalogItem implements Serializable {
    protected String isbn;
    protected String title;
    protected int publicationYear;
    protected int numberOfPages;

    public CatalogItem(String isbn, String title, int publicationYear, int numberOfPages) {
        this.isbn = isbn;
        this.title = title;
        this.publicationYear = publicationYear;
        this.numberOfPages = numberOfPages;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }
}
