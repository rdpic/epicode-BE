package it.epicode.dao;

import it.epicode.entity.Mezzo;

import javax.persistence.*;

public class MezzoDAO {
    private EntityManager em;

    public MezzoDAO(EntityManager em) {
        this.em = em;
    }

    public void addMezzo(Mezzo mezzo) {
        em.getTransaction().begin();
        em.persist(mezzo);
        em.getTransaction().commit();
    }

    public Mezzo findMezzoById(Long id) {
        return em.find(Mezzo.class, id);
    }

    public void updateMezzo(Mezzo mezzo) {
        em.getTransaction().begin();
        em.merge(mezzo);
        em.getTransaction().commit();
    }

    public void deleteMezzoById(Long id) {
        em.getTransaction().begin();
        Mezzo mezzo = em.find(Mezzo.class, id);
        if (mezzo != null) {
            em.remove(mezzo);
        }
        em.getTransaction().commit();
    }
}
