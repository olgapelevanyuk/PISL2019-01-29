package by.it.group673602.chernyak.laboratory05.dao;

import by.bsuir.userhibernate.entity.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Optional;


public class UserdataDaoImpl implements by.bsuir.userhibernate.dao.UserdataDao<by.bsuir.userhibernate.entity.User> {

    private UserdataDaoImpl() {
    }

    private final static class SingletonHolder {
        private final static by.bsuir.userhibernate.dao.UserdataDaoImpl INSTANCE = new by.bsuir.userhibernate.dao.UserdataDaoImpl();
    }

    public static by.bsuir.userhibernate.dao.UserdataDaoImpl getInstance() {
        return SingletonHolder.INSTANCE;
    }


    public List<User> findAll() {
        Session session = by.bsuir.userhibernate.util.HibernateUtil.getSessionFactory().openSession();
        List<User> userdata = session.createQuery("from User ").list();
        session.close();
        return userdata;
    }

    public Optional<User> findById(int id) {
        Session session = by.bsuir.userhibernate.util.HibernateUtil.getSessionFactory().openSession();
        Optional<User> userdata = Optional.of(session.get(by.bsuir.userhibernate.entity.User.class, id));
        session.close();
        return userdata;
    }

    public void create(by.bsuir.userhibernate.entity.User userdata) {
        Transaction tx = null;
        try (Session session = by.bsuir.userhibernate.util.HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.save(userdata);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }

    public void delete(by.bsuir.userhibernate.entity.User userdata) {
        Transaction tx = null;
        try (Session session = by.bsuir.userhibernate.util.HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.delete(userdata);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }

    public void update(by.bsuir.userhibernate.entity.User userdata) {
        Transaction tx = null;
        try (Session session = by.bsuir.userhibernate.util.HibernateUtil.getSessionFactory().openSession()) {
//            tx = session.beginTransaction();
            session.update(userdata);
//            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }
}
