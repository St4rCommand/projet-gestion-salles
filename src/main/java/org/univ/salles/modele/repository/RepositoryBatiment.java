package org.univ.salles.modele.repository;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.univ.salles.modele.entite.Batiment;

import java.util.ArrayList;
import java.util.List;

public class RepositoryBatiment extends AbstractRepository {

    public List getBatiments() {

        Session session = null;
        List result = null;

        try {
            session = sessionFactory.openSession();
            result = session.createCriteria(Batiment.class).addOrder(Order.asc("nom")).list();
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
