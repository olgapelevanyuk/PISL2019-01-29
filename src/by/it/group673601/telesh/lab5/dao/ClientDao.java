package by.it.group673601.telesh.lab5.dao;

import lab5.dao.Enity.ClientEntity;
import lab5.utils.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

/**
 * Created by user on 23.04.2019.
 */
public class ClientDao {

    public ClientEntity findById(int id){
        return HibernateUtil.getSessionFactory().openSession().get(ClientEntity.class,id);
    }

    public void update(ClientEntity client){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(client);
        session.getTransaction().commit();
        session.close();
    }

    public void save(ClientEntity client){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(client);
        session.getTransaction().commit();
        session.close();
    }

    public void delete(ClientEntity client){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(client);
        session.getTransaction().commit();
        session.close();
    }

    public List<ClientEntity> findAll(){
        List<ClientEntity> users = (List<ClientEntity>) HibernateUtil.getSessionFactory().openSession().createQuery("From ClientEntity ").list();

        return users;
    }
}
