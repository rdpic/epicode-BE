package it.epicode.dao;

import it.epicode.entity.Rivenditore;

import javax.persistence.*;

public class RivenditoreDAO {
    private EntityManager em;

    public RivenditoreDAO(EntityManager em) {
        this.em = em;
    }

    public void addRivenditore(Rivenditore rivenditore) {
        em.getTransaction().begin();
        em.persist(rivenditore);
        em.getTransaction().commit();
    }

    public Rivenditore findRivenditoreById(Long id) {
        return em.find(Rivenditore.class, id);
    }

    public void updateRivenditore(Rivenditore rivenditore) {
        em.getTransaction().begin();
        em.merge(rivenditore);
        em.getTransaction().commit();
    }

    public void deleteRivenditoreById(Long id) {
        em.getTransaction().begin();
        Rivenditore rivenditore = em.find(Rivenditore.class, id);
        if (rivenditore != null) {
            em.remove(rivenditore);
        }
        em.getTransaction().commit();
    }
}
