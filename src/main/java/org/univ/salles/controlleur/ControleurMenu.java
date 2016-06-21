package org.univ.salles.controlleur;

import org.univ.salles.modele.repository.RepositorySalle;
import org.univ.salles.vue.reservation.FenetreReservation;
import org.univ.salles.vue.salle.FenetreCreationSalle;

public class ControleurMenu {

    public void reserverSalle() {
        ControleurReservation.reserverSalle();
    }

    public void creerSalle() {
        ControleurSalle.CreerSalleFenetre();
    }
}
