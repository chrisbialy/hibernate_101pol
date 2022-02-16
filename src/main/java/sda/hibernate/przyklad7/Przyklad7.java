package sda.hibernate.przyklad7;

import org.hibernate.Session;
import sda.hibernate.dao.UserCriteriaDao;
import sda.hibernate.model.Product;
import sda.hibernate.util.HibernateUtil;

public class Przyklad7 {
    public static void main(String[] args) {
        UserCriteriaDao userCriteriaDao = new UserCriteriaDao();
        /*userCriteriaDao.findUserWhereNameContains("sk")
                .forEach(System.out::println);

        userCriteriaDao.findAllByCountryAlias("DE").forEach(System.out::println);*/

        Session session = HibernateUtil.getSessionFactory().openSession();
        Product product = session.find(Product.class, 2);

        //userCriteriaDao.findAllWhoBoughtProduct(product).forEach(System.out::println);

        userCriteriaDao.findNonCriterisAllWhoBoughtProduct(product).forEach(System.out::println);

    }
}