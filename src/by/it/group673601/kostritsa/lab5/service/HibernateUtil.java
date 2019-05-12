package by.it.group673601.kostritsa.lab5.service;

import lab5.entity.Citizen;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.io.File;

public class HibernateUtil {
    private static SessionFactory sessionFactory;

    static {
        try {
            File file = new File("D:\\study\\3курс,2сем\\PISL2019-01-29\\hibernate.cfg.xml");
            Configuration configuration = new Configuration().configure(file);
            configuration.addAnnotatedClass(Citizen.class);
            StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
            sessionFactory = configuration.buildSessionFactory(builder.build());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static SessionFactory getSessionFactory(){
        return sessionFactory;
    }
}
