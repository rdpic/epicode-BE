package it.epicode;

import it.epicode.dao.*;
import it.epicode.entity.*;
import it.epicode.enums.Frequency;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("week3project");
        EntityManager em = emf.createEntityManager();

        ItemDAO itemDAO = new ItemDAO(em);
        UserDAO userDAO = new UserDAO(em);
        LoanDAO loanDAO = new LoanDAO(em);

        Book b1 = new Book();
        b1.setIsbn("9780062105554");
        b1.setTitle("I Am Number Four");
        b1.setAuthor("Pittacus Lore");
        b1.setGenre("Sci-Fi");
        b1.setPageCount(480);
        b1.setPublicationYear(2010);
        try {
            itemDAO.save(b1);
            System.out.println("Item saved.");
        } catch (Exception e) {
            System.err.println("Item already exists.");
        }

        Book b2 = new Book();
        b2.setIsbn("9780062070623");
        b2.setTitle("The Power of Six");
        b2.setAuthor("Pittacus Lore");
        b2.setGenre("Sci-Fi");
        b2.setPageCount(448);
        b2.setPublicationYear(2011);
        try {
            itemDAO.save(b2);
            System.out.println("Item saved.");
        } catch (Exception e) {
            System.err.println("Item already exists.");
        }

        Magazine m1 = new Magazine();
        m1.setIsbn("9788856431007");
        m1.setTitle("The Sun");
        m1.setPageCount(123);
        m1.setFrequency(Frequency.WEEKLY);
        m1.setPublicationYear(2024);
        try {
            itemDAO.save(m1);
            System.out.println("Item saved.");
        } catch (Exception e) {
            System.err.println("Item already exists.");
        }

        System.out.println("---------------------");

        try {
            CatalogItem item = itemDAO.getByIsbn("1111111111111");
            if (item != null) {
                itemDAO.delete(item);
                System.out.println("Item deleted.");
            } else {
                throw new RuntimeException("Item not found.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("---------------------");

        try {
            CatalogItem item = itemDAO.getByIsbn("9780062105554");
            if (item != null) {
                itemDAO.delete(item);
                System.out.println("Item deleted.");
            } else {
                throw new RuntimeException("Item not found.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("---------------------");

        CatalogItem findItem = itemDAO.getByIsbn("9780062070623");
        if (findItem != null) {
            System.out.println(findItem);
        } else {
            System.err.println("Item not found.");
        }

        System.out.println("--------------------");

        System.out.println("Pittacus Lore");
        List<CatalogItem> itemsByAuthor = itemDAO.findByAuthor("Lore");
        if (itemsByAuthor.isEmpty()) {
            System.err.println("Items not found.");
        } else {
            itemsByAuthor.forEach(System.out::println);
        }

        System.out.println("---------------------");

        System.out.println("2010 Items");
        List<CatalogItem> itemsByYear = itemDAO.findByYear(2010);
        if (itemsByYear.isEmpty()) {
            System.err.println("Items not found.");
        }else {
            itemsByYear.forEach(System.out::println);
        }

        System.out.println("---------------------");

        System.out.println("Items with 'Power' in their title");
        List<CatalogItem> itemsByTitle = itemDAO.findByTitle("Power");
        if (itemsByTitle.isEmpty()) {
            System.err.println("Items not found.");
        } else {
            itemsByTitle.forEach(System.out::println);
        }

        System.out.println("---------------------");

        User u1 = new User();
        u1.setFirstName("Riccardo");
        u1.setLastName("Del Piccolo");
        u1.setBirthDate(LocalDate.of(1998, 11, 28));
        try {
            userDAO.save(u1);
            System.out.println("User registered.");
        } catch (Exception e) {
            e.printStackTrace();
        }

        User u2 = new User();
        u2.setFirstName("Sergio");
        u2.setLastName("Del Piccolo");
        u2.setBirthDate(LocalDate.of(1962, 10, 13));
        try {
            userDAO.save(u2);
            System.out.println("User registered.");
        } catch (Exception e) {
            e.printStackTrace();
        }

        Loan ln1 = new Loan();
        ln1.setUser(userDAO.getById(1));
        ln1.setStartDate(LocalDate.now());
        ln1.setItem(itemDAO.getByIsbn("9780062070623"));
        try {
            loanDAO.save(ln1);
            System.out.println("Loan registered.");
        } catch (Exception e) {
            e.printStackTrace();
        }

        Loan ln2 = new Loan();
        ln2.setUser(userDAO.getById(2));
        ln2.setStartDate(LocalDate.now());
        ln2.setItem(itemDAO.getByIsbn("9788856431007"));
        try {
            loanDAO.save(ln2);
            System.out.println("Loan registered.");
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("--------------------------");

        System.out.println("Loaned items registered with user 2");
        List<CatalogItem> loanedItems = loanDAO.getItemsById(2);
        loanedItems.forEach(System.out::println);

        System.out.println("--------------------------");

        System.out.println("Not yet returned products");
        List<Loan> notReturnedLoans = loanDAO.getExpiredLoans();
        notReturnedLoans.forEach(System.out::println);
    }

}
