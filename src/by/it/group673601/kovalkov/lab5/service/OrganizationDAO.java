package lab5.service;

import lab5.entity.Citizen;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class OrganizationDAO {

    public Citizen findById(int id) {
        return HibernateUtil.getSessionFactory().openSession().get(Citizen.class, id);
    }

    public void save(Citizen user) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(user);
        tx1.commit();
        session.close();
    }

    public void update(Citizen user) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(user);
        tx1.commit();
        session.close();
    }

    public void delete(Citizen user) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(user);
        tx1.commit();
        session.close();
    }

    public List<Citizen> findAll() {
        List<Citizen> users = (List<Citizen>) HibernateUtil.getSessionFactory().openSession().createQuery("From Citizen").list();
        return users;
    }
}
