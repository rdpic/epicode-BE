package it.epicode;

public class Magazine extends CatalogItem {
    public enum Periodicity {
        WEEKLY, MONTHLY, SEMESTRAL
    }

    private Periodicity periodicity;

    public Magazine(String isbn, String title, int publicationYear, int numberOfPages, Periodicity periodicity) {
        super(isbn, title, publicationYear, numberOfPages);
        this.periodicity = periodicity;
    }

    // Getter and setter for periodicity
    public Periodicity getPeriodicity() {
        return periodicity;
    }

    public void setPeriodicity(Periodicity periodicity) {
        this.periodicity = periodicity;
    }
}
