package homework30.dao;

import homework30.entity.Student;
import homework30.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class StudentDAO implements GenericDAO<Student, Long>{

    @Override
    public void save(Student entity) {
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            session.persist(entity);
            transaction.commit();
        }
    }

    @Override
    public Student findById(Long aLong) {
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            return session.get(Student.class, aLong);
        }
    }

    @Override
    public Student findByField(String email) {
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            Query<Student> query = session.createQuery("from Student where email = :email", Student.class);
            query.setParameter("email", email);
            return query.uniqueResult();
        }
    }

    @Override
    public List<Student> findAll() {
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            return session.createQuery("from Student", Student.class).getResultList();
        }
    }

    @Override
    public Student update(Student student) {
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            session.update(student);
            transaction.commit();
            return student;
        }
    }

    @Override
    public boolean deleteById(Long id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            boolean flag = false;
            Student student = session.get(Student.class, id);
            if (student != null){
                session.remove(student);
                flag = true;
            }
            transaction.commit();
            return flag;
        }
    }
}
