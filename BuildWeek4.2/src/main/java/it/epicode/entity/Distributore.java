package it.epicode.entity;

import javax.persistence.*;

@Entity
@Table(name = "distributori")
public class Distributore {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String ubicazione;

    @Column(nullable = false)
    private boolean attivo;

    public Distributore(String ubicazione, boolean attivo) {
        this.ubicazione = ubicazione;
        this.attivo = attivo;
    }

    public Distributore() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUbicazione() {
        return ubicazione;
    }

    public void setUbicazione(String ubicazione) {
        this.ubicazione = ubicazione;
    }

    public boolean isAttivo() {
        return attivo;
    }

    public void setAttivo(boolean attivo) {
        this.attivo = attivo;
    }
}
