package sda.hibernate.przyklad2;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import sda.hibernate.model.Country;
import sda.hibernate.util.HibernateUtil;


public class Przyklad2 {
    public static void main(String[] args) {
        usePersist();
        //useMerge();
        //useUpdate();
        //useDelete();
    }

    //persist() zawsze tworzy nowy obiekt
//Służy do utrwalania obiektów. Jej wywołanie powoduje dołączenie przekazanego obiektu do zbioru obiektów zarządzanych oraz wywołanie INSERT
// w momencie zakończenia transakcji (albo wywołania flush). Jeżeli istnieje już encja o takim samym identyfikatorze dostaniemy wyjątek.
    public static void usePersist() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Country country = new Country();
        country.setAlias("IN");
        session.beginTransaction();
        session.persist(country);
        country.setName("India");
        session.getTransaction().commit();
        session.close();
    }
    //merge() aktualizuje lub dodaje nowy obiekt obiektu Session
// Służy do synchronizowania stanu obiektu w kontekście utrwalania. W przeciwieństwie do poprzedniej metody encja przekazana w argumencie nie jest dołączana do
// zbioru obiektów zarządzanych. Jest ona kopiowana, kopia trafia pod zarząd EntityManagera lub Session i jest zwracana.
// W momencie zakończenia transakcji wywoływany jest INSERT albo UPDATE w zależności czy istnieje rekord o danym identyfikatorze w bazie danych.*/
// W tym miejscu warto też wspomnieć o update() - update zadziała tylko wtedy gdy do naszej sesji nie spersistowaliśmy danego obiektu, kiedy obiekt będzie załadowany dostaniemy exception
// W przypadku merge jest to bez znaczenia jednakże jest on ciut mniej wydajny - w tym miejscu po prostu trzeba odpowiedzieć sobie na pytanie, czy dany obiekt będzie znajdował się w sesji
// gdy będę chciał go modyfikować (raczej dość rzadka sytuacja)
    public static void useMerge() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Country country = new Country();
        country.setId(1);
        country.setAlias("ES");
        country = (Country) session.merge(country);
        country.setName("Spain");
        session.getTransaction().commit();
        session.close();
    }

    public static void useUpdate() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Country country = new Country();
        country.setId(3);
        country.setName("Japan");
        session.update(country);
        country.setAlias("JP");
        session.getTransaction().commit();
        session.close();
    }

    public static void useDelete() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Country country = new Country();
        country.setId(3);
        session.delete(country);
        session.getTransaction().commit();
        session.close();
    }
}