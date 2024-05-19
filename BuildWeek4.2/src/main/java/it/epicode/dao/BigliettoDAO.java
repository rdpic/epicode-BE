package it.epicode.dao;

import it.epicode.entity.Biglietto;

import javax.persistence.*;

public class BigliettoDAO {
    private EntityManager em;

    public BigliettoDAO(EntityManager em) {
        this.em = em;
    }

    public void addBiglietto(Biglietto biglietto) {
        em.getTransaction().begin();
        em.persist(biglietto);
        em.getTransaction().commit();
    }

    public Biglietto findBigliettoById(Long id) {
        return em.find(Biglietto.class, id);
    }

    public void updateBiglietto(Biglietto biglietto) {
        em.getTransaction().begin();
        em.merge(biglietto);
        em.getTransaction().commit();
    }

    public void deleteBigliettoById(Long id) {
        em.getTransaction().begin();
        Biglietto biglietto = em.find(Biglietto.class, id);
        if (biglietto != null) {
            em.remove(biglietto);
        }
        em.getTransaction().commit();
    }
}
