package org.univ.salles.controlleur;

import org.univ.salles.modele.entite.Batiment;
import org.univ.salles.modele.entite.Salle;
import org.univ.salles.modele.entite.TypeSalle;
import org.univ.salles.modele.repository.RepositoryBatiment;
import org.univ.salles.modele.repository.RepositorySalle;
import org.univ.salles.modele.repository.RepositoryTypeSalle;
import org.univ.salles.vue.salle.FenetreCreationSalle;

import java.util.List;

public class ControleurSalle {

    private RepositorySalle repositorySalle;
    private RepositoryBatiment repositoryBatiment;
    private RepositoryTypeSalle repositoryTypeSalle;

    public ControleurSalle (RepositorySalle repositorySalle, RepositoryBatiment repositoryBatiment, RepositoryTypeSalle repositoryTypeSalle) {
        this.repositorySalle = repositorySalle;
        this.repositoryBatiment = repositoryBatiment;
        this.repositoryTypeSalle = repositoryTypeSalle;
    }

    public List getBatimentList() {
        return this.repositoryBatiment.getBatiments();
    }

    public List getTypesSalleList() {
        return this.repositoryTypeSalle.getTypesSalle();
    }

    public void addSalle(Batiment batiment, TypeSalle type, Integer numero, Integer etage, Integer superficie) {
        List listeSalles = this.repositorySalle.existe(batiment, type, numero, etage, superficie);

        if (listeSalles.size() == 0) {
            Salle nouvelleSalle = this.repositorySalle.creer(batiment, type, numero, etage, superficie);
            System.out.println(nouvelleSalle);
        }/*
        else
            new FenetreListeSalle(listeSalles);*/

    }

    public static void CreerSalleFenetre() {
        RepositorySalle repositorySalle = new RepositorySalle();
        RepositoryBatiment repositoryBatiment = new RepositoryBatiment();
        RepositoryTypeSalle repositoryTypeSalle= new RepositoryTypeSalle();
        ControleurSalle controleur = new ControleurSalle(repositorySalle, repositoryBatiment, repositoryTypeSalle);
        FenetreCreationSalle fenetre = new FenetreCreationSalle(controleur);
    }
}
