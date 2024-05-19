package it.epicode.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@DiscriminatorValue("Abbonamento")
public class Abbonamento extends TitoloDiViaggio {
    @Column(nullable = false)
    private LocalDate dataScadenza;

    @ManyToOne
    @JoinColumn(name = "utente_id", nullable = false)
    private Utente utente;

    public Abbonamento(LocalDate dataScadenza, Utente utente) {
        this.dataScadenza = dataScadenza;
        this.utente = utente;
    }

    public Abbonamento() {
    }

    public LocalDate getDataScadenza() {
        return dataScadenza;
    }

    public void setDataScadenza(LocalDate dataScadenza) {
        this.dataScadenza = dataScadenza;
    }

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }
}
