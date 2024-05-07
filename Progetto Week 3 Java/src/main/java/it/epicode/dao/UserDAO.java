package it.epicode.dao;

import it.epicode.entity.User;

import javax.persistence.*;
import java.util.List;

public class UserDAO {

    private EntityManager em;

    public UserDAO(EntityManager em) {
        this.em = em;
    }

    public void save(User userr) {
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(userr);
        et.commit();
    }

    public User getById(Integer id) {
        return em.find(User.class, id);
    }

    public void update(User userr) {
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.merge(userr);
        et.commit();
    }

    public List<User> findAll() {
        return em.createQuery("SELECT u FROM User u", User.class).getResultList();
    }

    public void delete(User userr) {
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.remove(userr);
        et.commit();
    }

}
