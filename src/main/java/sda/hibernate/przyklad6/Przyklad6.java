package sda.hibernate.przyklad6;

import org.hibernate.Session;
import sda.hibernate.model.Address;
import sda.hibernate.util.HibernateUtil;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class Przyklad6 {

    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Address> criteriaQuery = builder.createQuery(Address.class);
        Root<Address> addressRoot = criteriaQuery.from(Address.class);
        criteriaQuery.select(addressRoot);
        Query query = session.createQuery(criteriaQuery);
        List<Address> addresses = query.getResultList();
        addresses.forEach(address -> System.out.println(address.getCity()));

        session.close();
    }
}
