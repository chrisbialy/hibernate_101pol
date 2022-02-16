package sda.hibernate.przyklad5;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.query.Query;
import sda.hibernate.model.Country;
import sda.hibernate.util.HibernateUtil;


public class Przyklad5 {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query<Country> query = session.createNamedQuery("country.select.all", Country.class);
        query.getResultList().forEach(country -> System.out.println(country.getName()));
        session.close();
    }

}