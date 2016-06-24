package org.univ.salles.modele.repository;


import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.univ.salles.modele.entite.Batiment;
import org.univ.salles.modele.entite.Salle;
import org.univ.salles.modele.entite.TypeSalle;

import java.util.ArrayList;
import java.util.List;

public class RepositorySalle extends AbstractRepository {

    public List existe(Batiment batiment, TypeSalle type, Integer numero, Integer etage, Integer superficie) {

        Session session = null;
        List result = new ArrayList<Salle>();

        try {
            session = sessionFactory.openSession();
            result = (List) session.createCriteria(Batiment.class)
                    .add(Restrictions.eq("batiment", batiment))
                    .add(Restrictions.eq("type", type))
                    .add(Restrictions.eq("noSalle", numero))
                    .add(Restrictions.eq("noEtage", etage))
                    .add(Restrictions.eq("superficie", superficie));
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }

        return result;
    }

    public Salle creer(Batiment batiment, TypeSalle type, Integer numero, Integer etage, Integer superficie) {

        Session session = null;
        Transaction tx = null;
        Salle nouvelleSalle = null;

        try {
            nouvelleSalle = new Salle(numero, etage, superficie, batiment, type);
            session = sessionFactory.openSession();
            tx = session.beginTransaction();

            session.save(nouvelleSalle);

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

        return nouvelleSalle;
    }

    public List getSalles() {

        Session session = null;
        List result = null;

        try {
            session = sessionFactory.openSession();
            result = session.createCriteria(Salle.class).list();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }

        return result;
    }

}
