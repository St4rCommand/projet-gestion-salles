package org.univ.salles.modele.repository;

import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.univ.salles.modele.entite.Batiment;
import org.univ.salles.modele.entite.Demandeur;

import java.util.ArrayList;
import java.util.List;

public class RepositoryDemandeur extends AbstractRepository {

    public List getDemandeurs() {

        Session session = null;
        List result = new ArrayList<Demandeur>();

        try {
            session = sessionFactory.openSession();
            result = session.createCriteria(Demandeur.class).addOrder(Order.asc("nom")).list();
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
