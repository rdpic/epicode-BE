package it.epicode;

public class Book extends CatalogItem {
    private String author;
    private String genre;

    public Book(String isbn, String title, int publicationYear, int numberOfPages, String author, String genre) {
        super(isbn, title, publicationYear, numberOfPages);
        this.author = author;
        this.genre = genre;
    }

    // Getters and setters for author and genre
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
