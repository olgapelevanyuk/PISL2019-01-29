package by.it.group673602.klezovich.hibernate.dao;

import java.util.List;
import java.util.Optional;

import by.it.group673602.klezovich.hibernate.entity.User;
import by.it.group673602.klezovich.hibernate.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class UserdataDaoImpl implements UserdataDao<User> {

    private UserdataDaoImpl() {
    }

    private final static class SingletonHolder {
        private final static UserdataDaoImpl INSTANCE = new UserdataDaoImpl();
    }

    public static UserdataDaoImpl getInstance() {
        return SingletonHolder.INSTANCE;
    }


    public List<User> findAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<User> userdata = session.createQuery("from User ").list();
        session.close();
        return userdata;
    }

    public Optional<User> findById(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Optional<User> userdata = Optional.of(session.get(User.class, id));
        session.close();
        return userdata;
    }

    public void create(User userdata) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.save(userdata);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }

    public void delete(User userdata) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.delete(userdata);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }

    public void update(User userdata) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.update(userdata);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }
}
