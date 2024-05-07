package it.epicode.entity;

import it.epicode.enums.Frequency;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "magazines")
public class Magazine extends CatalogItem implements Serializable {
    @Enumerated(EnumType.STRING)
    private Frequency frequency;

    public Magazine() {}

    public Magazine(String isbn, String title, int publicationYear, int pageCount, Frequency frequency) {
        super(isbn, title, publicationYear, pageCount);
        this.frequency = frequency;
    }

    public Frequency getFrequency() {
        return frequency;
    }

    public void setFrequency(Frequency frequency) {
        this.frequency = frequency;
    }
}
