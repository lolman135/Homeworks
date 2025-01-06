package homework31.utils;

import lombok.Getter;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    @Getter
    private static final SessionFactory sessionFactory = buildSessionfactory();

    private static SessionFactory buildSessionfactory() {
        SessionFactory newSessionFactory = null;

        try {
            newSessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        } catch (Exception e){
            System.out.println("Error: " + e.getMessage());
        }

        return newSessionFactory;
    }

    public static void shutDown(){
        sessionFactory.close();
    }
}
