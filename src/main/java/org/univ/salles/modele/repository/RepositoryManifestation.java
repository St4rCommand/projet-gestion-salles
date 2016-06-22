package org.univ.salles.modele.repository;

import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.univ.salles.modele.entite.Demandeur;
import org.univ.salles.modele.entite.Manifestation;

import java.util.ArrayList;
import java.util.List;

public class RepositoryManifestation extends AbstractRepository {

    public List getManifestations() {

        Session session = null;
        List result = new ArrayList<Demandeur>();

        try {
            session = sessionFactory.openSession();
            result = session.createCriteria(Manifestation.class).addOrder(Order.asc("nom")).list();
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
