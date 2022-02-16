package sda.hibernate.przyklad4;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import sda.hibernate.model.Country;
import sda.hibernate.util.HibernateUtil;

public class Przyklad4 {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        NativeQuery<Country> nativeQuery = session.createNativeQuery(
                        "select * from Country where co_name=:name",
                        Country.class)
                .setParameter("name", "Poland");

        nativeQuery.getResultList().forEach(country -> System.out.println(country.getName()));
        session.close();


    }
}