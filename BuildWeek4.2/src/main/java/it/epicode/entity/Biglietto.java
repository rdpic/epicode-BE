package it.epicode.entity;

import javax.persistence.*;

@Entity
@DiscriminatorValue("Biglietto")
public class Biglietto extends TitoloDiViaggio {

    @ManyToOne
    @JoinColumn(name = "mezzo_id", nullable = false)
    private Mezzo mezzo;

    @ManyToOne
    @JoinColumn(name = "utente_id", nullable = false)
    private Utente utente;

    public Biglietto(Mezzo mezzo, Utente utente) {
        this.mezzo = mezzo;
        this.utente = utente;
    }

    public Biglietto() {
    }

    public Mezzo getMezzo() {
        return mezzo;
    }

    public void setMezzo(Mezzo mezzo) {
        this.mezzo = mezzo;
    }

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }
}
