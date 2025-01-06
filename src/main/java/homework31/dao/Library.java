package homework31.dao;

import homework31.entity.Book;
import homework31.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class Library {

    public Book addBook(Book book) {

        if (book == null || !book.isValid()){
            throw new IllegalArgumentException("Wrong data");
        }

        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Book persistedBook = (Book) session.merge(book);
            transaction.commit();
            return persistedBook;
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            throw new RuntimeException("Error while adding book", e);
        }
    }

    public boolean removeBook(int id) {
        System.out.println("book id: " + id);
        if(id <= 0){
            throw new IllegalArgumentException("Wrong id");
        }

        Transaction transaction = null;
        boolean isDeleted = false;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Book book = session.get(Book.class, id);
            session.remove(book);
            transaction.commit();
            isDeleted = true;
        } catch (Exception e) {
            throw new IllegalArgumentException("Wrong data provided");
        }
        return isDeleted;
    }

    public List<Book> getBooks() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Book", Book.class).getResultList();
        }
    }

    public int getBookCount() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return ((Long) session.createQuery("select count(b) from Book b").getSingleResult()).intValue();
        }
    }
}