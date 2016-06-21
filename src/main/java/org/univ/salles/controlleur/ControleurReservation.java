package org.univ.salles.controlleur;

import org.univ.salles.modele.repository.RepositoryBatiment;
import org.univ.salles.modele.repository.RepositorySalle;
import org.univ.salles.modele.repository.RepositoryTypeSalle;
import org.univ.salles.vue.reservation.FenetreReservation;
import org.univ.salles.vue.salle.FenetreCreationSalle;

import java.util.List;

public class ControleurReservation {

    private RepositorySalle repositorySalle;
    private RepositoryBatiment repositoryBatiment;
    private RepositoryTypeSalle repositoryTypeSalle;

    public ControleurReservation (RepositorySalle repositorySalle, RepositoryBatiment repositoryBatiment, RepositoryTypeSalle repositoryTypeSalle) {
        this.repositorySalle = repositorySalle;
        this.repositoryBatiment = repositoryBatiment;
        this.repositoryTypeSalle = repositoryTypeSalle;
    }

    public List getSalleList() {
        return this.repositorySalle.getSalles();
    }

    public static void reserverSalle() {
        RepositorySalle repositorySalle = new RepositorySalle();
        RepositoryBatiment repositoryBatiment = new RepositoryBatiment();
        RepositoryTypeSalle repositoryTypeSalle= new RepositoryTypeSalle();
        ControleurReservation controleur = new ControleurReservation(repositorySalle, repositoryBatiment, repositoryTypeSalle);
        FenetreReservation fenetre = new FenetreReservation(controleur);
    }
}
