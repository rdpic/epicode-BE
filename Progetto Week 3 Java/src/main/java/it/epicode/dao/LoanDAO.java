package it.epicode.dao;

import it.epicode.entity.CatalogItem;
import it.epicode.entity.Loan;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class LoanDAO {

    private EntityManager em;

    public LoanDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Loan loan) {
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(loan);
        et.commit();
    }

    public Loan getById(Integer id) {
        return em.find(Loan.class, id);
    }

    public List<CatalogItem> getItemsById(Integer id) {
        return em.createQuery("SELECT ci FROM CatalogItem ci", Loan.class)
                .getResultStream()
                .map(Loan::getItem)
                .collect(Collectors.toList());
    }

    public List<Loan> getExpiredLoans() {
        LocalDate today = LocalDate.now();

        return em.createQuery("SELECT ln FROM Loan ln WHERE ln.actualReturnDate IS NULL OR " +
                        "pr.expectedReturnDate < :today", Loan.class)
                .setParameter("today", today)
                .getResultList();
    }

    public void update(Loan loan) {
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.merge(loan);
        et.commit();
    }

    public List<Loan> findAll() {
        return em.createQuery("SELECT ln FROM Loan ln", Loan.class).getResultList();
    }

    public void delete(Loan loan) {
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.remove(loan);
        et.commit();
    }

}
