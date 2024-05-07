package it.epicode.dao;

import it.epicode.entity.CatalogItem;

import javax.persistence.*;
import java.util.List;

public class ItemDAO {

    private EntityManager em;

    public ItemDAO(EntityManager em) {
        this.em = em;
    }

    public void save(CatalogItem item) {
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(item);
        et.commit();
    }

    public CatalogItem getByIsbn(String isbn) {
        return em.find(CatalogItem.class, isbn);
    }

    public void update(CatalogItem item) {
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.merge(item);
        et.commit();
    }

    public List<CatalogItem> findAll() {
        return em.createQuery("SELECT i FROM CatalogItem i", CatalogItem.class).getResultList();
    }

    public List<CatalogItem> findByYear(Integer year) {
        return em.createQuery("SELECT i FROM CatalogItem i WHERE publication_year = :year", CatalogItem.class)
                .setParameter("year", year)
                .getResultList();
    }

    public List<CatalogItem> findByAuthor(String author) {
        return em.createQuery("SELECT i FROM CatalogItem i WHERE author LIKE :author", CatalogItem.class)
                .setParameter("author", "%"+author+"%")
                .getResultList();
    }

    public List<CatalogItem> findByTitle(String title) {
        return em.createQuery("SELECT i FROM CatalogItem i WHERE title LIKE :title", CatalogItem.class)
                .setParameter("title", "%"+title+"%")
                .getResultList();
    }

    public void delete(CatalogItem item) {
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.remove(item);
        et.commit();
    }

}
