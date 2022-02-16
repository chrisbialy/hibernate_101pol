package sda.hibernate.homework;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import sda.hibernate.model.Country;
import sda.hibernate.model.User;
import sda.hibernate.util.HibernateUtil;


public class Homework {

    public static void main(String[] args) {

       /* SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        User user = session.find(User.class, 1);
        System.out.println(user.getUserName());
        session.close();
        sessionFactory.close();*/

        usePersist();

    }

    public static void usePersist() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.close();
    }
}
