package org.univ.salles;

import org.univ.salles.controlleur.ControleurMenu;
import org.univ.salles.vue.accueil.FenetrePrincipale;

import static org.univ.salles.modele.repository.AbstractRepository.configureSessionFactory;

public class GestionSalles {

    public static void main (String[] args) {
        configureSessionFactory();
        FenetrePrincipale fenetrePrincipale = new FenetrePrincipale(new ControleurMenu());
    }
}
