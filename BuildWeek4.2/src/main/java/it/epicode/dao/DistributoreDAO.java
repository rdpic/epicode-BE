package it.epicode.dao;

import it.epicode.entity.Distributore;

import javax.persistence.EntityManager;

public class DistributoreDAO {
    private EntityManager em;

    public DistributoreDAO(EntityManager em) {
        this.em = em;
    }

    public void addDistributore(Distributore distributore) {
        em.getTransaction().begin();
        em.persist(distributore);
        em.getTransaction().commit();
    }

    public Distributore findDistributoreById(Long id) {
        return em.find(Distributore.class, id);
    }

    public void updateDistributore(Distributore distributore) {
        em.getTransaction().begin();
        em.merge(distributore);
        em.getTransaction().commit();
    }

    public void deleteDistributoreById(Long id) {
        em.getTransaction().begin();
        Distributore distributore = em.find(Distributore.class, id);
        if (distributore != null) {
            em.remove(distributore);
        }
        em.getTransaction().commit();
    }
}
