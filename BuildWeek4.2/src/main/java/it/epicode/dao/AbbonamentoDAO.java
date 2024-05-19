package it.epicode.dao;

import it.epicode.entity.Abbonamento;

import javax.persistence.*;

public class AbbonamentoDAO {
    private EntityManager em;

    public AbbonamentoDAO(EntityManager em) {
        this.em = em;
    }

    public void addAbbonamento(Abbonamento abbonamento) {
        em.getTransaction().begin();
        em.persist(abbonamento);
        em.getTransaction().commit();
    }

    public Abbonamento findAbbonamentoById(Long id) {
        return em.find(Abbonamento.class, id);
    }

    public void updateAbbonamento(Abbonamento abbonamento) {
        em.getTransaction().begin();
        em.merge(abbonamento);
        em.getTransaction().commit();
    }

    public void deleteAbbonamentoById(Long id) {
        em.getTransaction().begin();
        Abbonamento abbonamento = em.find(Abbonamento.class, id);
        if (abbonamento != null) {
            em.remove(abbonamento);
        }
        em.getTransaction().commit();
    }
}
