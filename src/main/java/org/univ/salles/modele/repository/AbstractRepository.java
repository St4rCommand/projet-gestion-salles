package org.univ.salles.modele.repository;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.univ.salles.modele.entite.*;

import java.util.Properties;
import java.util.ArrayList;
import java.util.List;

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
        TypeSalle type1 = new TypeSalle("Salle de réunion");
        TypeSalle type2 = new TypeSalle("Théatre");
        TypeSalle type3 = new TypeSalle("Auditorium");
        TypeSalle type4 = new TypeSalle("Salle des fêtes");

        Batiment batimentA = new Batiment("Batiment A");
        Batiment batimentB = new Batiment("Batiment B");

        Demandeur demandeurA = new Demandeur("Romain HUNAULT");
        Demandeur demandeurB = new Demandeur("Rémi FLORIN");
        Demandeur demandeurC = new Demandeur("Antoine LEBOEUF");

        Manifestation manifestationA = new Manifestation("Concert");
        Manifestation manifestationB = new Manifestation("Réunion");
        Manifestation manifestationC = new Manifestation("Mariage");

        Materiel materielA = new Materiel("Appareil photo");
        Materiel materielB = new Materiel("Vidéoprojecteur");
        Materiel materielC = new Materiel("Téléviseur");

        Session session = null;
        Transaction tx = null;
        List result = new ArrayList<Batiment>();

        try {
            session = sessionFactory.openSession();
            result = session.createCriteria(Batiment.class).list();

            if (result.isEmpty()) {

              tx = session.beginTransaction();

              session.save(type1);
              session.save(type2);
              session.save(type3);
              session.save(type4);

              session.save(batimentA);
              session.save(batimentB);

              session.save(demandeurA);
              session.save(demandeurB);
              session.save(demandeurC);

              session.save(manifestationA);
              session.save(manifestationB);
              session.save(manifestationC);

              session.save(materielA);
              session.save(materielB);
              session.save(materielC);

              session.flush();
              tx.commit();
          }
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
