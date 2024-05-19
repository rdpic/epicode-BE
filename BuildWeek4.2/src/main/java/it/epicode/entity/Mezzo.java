package it.epicode.entity;

import javax.persistence.*;

@Entity
@Table(name = "mezzi")
public class Mezzo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String tipo;

    @Column(nullable = false)
    private int capienza;

    @Column(name = "in_servizio", nullable = false)
    private boolean inServizio;

    public Mezzo(String tipo, int capienza, boolean inServizio) {
        this.tipo = tipo;
        this.capienza = capienza;
        this.inServizio = inServizio;
    }

    public Mezzo() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getCapienza() {
        return capienza;
    }

    public void setCapienza(int capienza) {
        this.capienza = capienza;
    }

    public boolean isInServizio() {
        return inServizio;
    }

    public void setInServizio(boolean inServizio) {
        this.inServizio = inServizio;
    }
}


