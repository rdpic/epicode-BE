package it.epicode.dao;

import it.epicode.entity.Utente;

import javax.persistence.*;

public class UtenteDAO {
    private EntityManager em;

    public UtenteDAO(EntityManager em) {
        this.em = em;
    }

    public void addUtente(Utente utente) {
        em.getTransaction().begin();
        em.persist(utente);
        em.getTransaction().commit();
    }

    public Utente findUtenteById(Long id) {
        return em.find(Utente.class, id);
    }

    public void updateUtente(Utente utente) {
        em.getTransaction().begin();
        em.merge(utente);
        em.getTransaction().commit();
    }

    public void deleteUtente(Utente utente) {
        em.getTransaction().begin();
        em.remove(utente);
        em.getTransaction().commit();
    }

    public void deleteUtenteById(Long id) {
        em.getTransaction().begin();
        Utente utente = em.find(Utente.class, id);
        if (utente != null) {
            em.remove(utente);
        }
        em.getTransaction().commit();
    }

    public Utente findUtenteByEmail(String email) {
        try {
            return em.createQuery("SELECT u FROM Utente u WHERE u.email = :email", Utente.class)
                    .setParameter("email", email)
                    .getSingleResult();
        } catch (Exception e) {
            return null; // Gestire l'assenza di risultati o eventuali errori
        }
    }
}
