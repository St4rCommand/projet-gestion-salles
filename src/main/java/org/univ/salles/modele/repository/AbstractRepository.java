package org.univ.salles.modele.repository;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.univ.salles.modele.entite.Batiment;
import org.univ.salles.modele.entite.TypeSalle;

import java.util.Properties;

public abstract class AbstractRepository {

    protected static SessionFactory sessionFactory = null;
    protected static ServiceRegistry serviceRegistry = null;

    public static SessionFactory configureSessionFactory() throws HibernateException {
        Configuration configuration = new Configuration();
        configuration.configure();

        Properties properties = configuration.getProperties();

        serviceRegistry = new ServiceRegistryBuilder().applySettings(properties).buildServiceRegistry();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);

        initData();

        return sessionFactory;
    }

    public static void initData() {
        TypeSalle type1 = new TypeSalle("Réunion");
        TypeSalle type2 = new TypeSalle("Concert");

        Batiment batimentA = new Batiment("Batiment A");
        Batiment batimentB = new Batiment("Batiment B");

        Session session = null;
        Transaction tx = null;

        try {
            session = sessionFactory.openSession();
            tx = session.beginTransaction();

            session.save(type1);
            session.save(type2);

            session.save(batimentA);
            session.save(batimentB);

            session.flush();
            tx.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            tx.rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
