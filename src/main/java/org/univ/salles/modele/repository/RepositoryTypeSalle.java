package org.univ.salles.modele.repository;

import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.univ.salles.modele.entite.Batiment;
import org.univ.salles.modele.entite.TypeSalle;

import java.util.ArrayList;
import java.util.List;

public class RepositoryTypeSalle extends AbstractRepository{

    public List getTypesSalle() {

        Session session = null;
        List result = null;

        try {
            session = sessionFactory.openSession();
            result = session.createCriteria(TypeSalle.class).addOrder(Order.asc("libelle")).list();
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
