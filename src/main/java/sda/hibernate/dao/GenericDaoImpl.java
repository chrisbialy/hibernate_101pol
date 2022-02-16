package sda.hibernate.dao;

import org.hibernate.Session;
import sda.hibernate.util.HibernateUtil;

import java.util.List;

public class GenericDaoImpl<T> implements GenericDao<T> {

    private Class<T> entityClass;

    public GenericDaoImpl(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    @Override
    public T findById(int id) {
        Session session = openSession();
        T result = session.find(entityClass, id);
        session.close();
        return result;
    }

    @Override
    public void insertObject(T t) {
        Session session = openSession();
        session.beginTransaction();
        session.persist(t);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void deleteObject(T t) {
        Session session = openSession();
        session.beginTransaction();
        session.delete(t);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void deleteObject(int id) {
        T t = findById(id);
        if (t != null) {
            Session session = openSession();
            session.beginTransaction();
            session.delete(findById(id));
            session.getTransaction().commit();
            session.close();
        }
    }

    @Override
    public void updateObject(T t, int id) {

    }

    @Override
    public List<T> getAll() {
        try (Session session = openSession()) {
            return session.createQuery("from "+entityClass.getName(),
                            entityClass)
                    .getResultList();
        }
    }

    @Override
    public List<T> getAll(int maxResults, int firstResult) {
        try (Session session = openSession()) {
            return session.createQuery("from "+entityClass.getName(),
                            entityClass)
                    .setMaxResults(maxResults)
                    .setFirstResult(firstResult)
                    .getResultList();
        }
    }

    private Session openSession() {
        return HibernateUtil.getSessionFactory().openSession();
    }
}