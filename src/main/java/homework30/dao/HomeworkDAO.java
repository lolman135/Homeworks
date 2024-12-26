package homework30.dao;

import homework30.entity.Homework;

import homework30.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class HomeworkDAO implements GenericDAO<Homework, Long> {

    @Override
    public void save(Homework entity) {
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            session.persist(entity);
            transaction.commit();
        }
    }

    @Override
    public Homework findById(Long id) {
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            return session.get(Homework.class, id);
        }
    }

    @Override
    public Homework findByField(String description) {
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            Query<Homework> query = session.createQuery("from Homework where description = :description", Homework.class);
            query.setParameter("description", description);
            return query.uniqueResult();
        }
    }

    @Override
    public List<Homework> findAll() {
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            return session.createQuery("from Homework", Homework.class).getResultList();
        }
    }

    @Override
    public Homework update(Homework homework) {
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            session.update(homework);
            transaction.commit();
            return homework;
        }
    }

    @Override
    public boolean deleteById(Long id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            boolean flag = false;
            Homework homework = session.get(Homework.class, id);
            if (homework != null){
                session.remove(homework);
                flag = true;
            }
            transaction.commit();
            return flag;
        }
    }
}
