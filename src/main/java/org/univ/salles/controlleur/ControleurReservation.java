package org.univ.salles.controlleur;

import org.univ.salles.modele.entite.TypeSalle;
import org.univ.salles.modele.repository.*;
import org.univ.salles.vue.reservation.FenetreReservation;

import java.util.Date;
import java.util.List;

public class ControleurReservation {

    private RepositorySalle repositorySalle;
    private RepositoryBatiment repositoryBatiment;
    private RepositoryTypeSalle repositoryTypeSalle;
    private RepositoryDemandeur repositoryDemandeur;
    private RepositoryManifestation repositoryManifestation;
    private RepositoryMateriel repositoryMateriel;

    public ControleurReservation (
            RepositorySalle repositorySalle,
            RepositoryBatiment repositoryBatiment,
            RepositoryTypeSalle repositoryTypeSalle,
            RepositoryDemandeur repositoryDemandeur,
            RepositoryManifestation repositoryManifestation,
            RepositoryMateriel repositoryMateriel
    ) {
        this.repositorySalle = repositorySalle;
        this.repositoryBatiment = repositoryBatiment;
        this.repositoryTypeSalle = repositoryTypeSalle;
        this.repositoryDemandeur = repositoryDemandeur;
        this.repositoryManifestation = repositoryManifestation;
        this.repositoryMateriel = repositoryMateriel;
    }

    public List getSalleList() {
        return this.repositorySalle.getSalles();
    }

    public List getDemandeurList() {
        return this.repositoryDemandeur.getDemandeurs();
    }

    public List getTypesSalleList() {
        return this.repositoryTypeSalle.getTypesSalle();
    }

    public List getManifestationList() {
        return this.repositoryManifestation.getManifestations();
    }

    public List getMaterielList() {
        return this.repositoryMateriel.getMateriels();
    }

    public List getSalleList(Date date, Integer duree, TypeSalle type) {
        // TODO faire une véritable fonction de recherche !
        return this.repositorySalle.getSalles();
    }

    public static void reserverSalle() {
        RepositorySalle repositorySalle = new RepositorySalle();
        RepositoryBatiment repositoryBatiment = new RepositoryBatiment();
        RepositoryTypeSalle repositoryTypeSalle= new RepositoryTypeSalle();
        RepositoryDemandeur repositoryDemandeur= new RepositoryDemandeur();
        RepositoryManifestation repositoryManifestation = new RepositoryManifestation();
        RepositoryMateriel repositoryMateriel = new RepositoryMateriel();
        ControleurReservation controleur = new ControleurReservation(
                repositorySalle,
                repositoryBatiment,
                repositoryTypeSalle,
                repositoryDemandeur,
                repositoryManifestation,
                repositoryMateriel
        );
        FenetreReservation fenetre = new FenetreReservation(controleur);
    }
}
