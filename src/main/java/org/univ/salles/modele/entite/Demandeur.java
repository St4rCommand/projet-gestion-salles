package org.univ.salles.modele.entite;

import javax.persistence.*;

@Entity
@Table(name = "demandeur")
public class Demandeur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;

    public Demandeur(String nom) {
        this.nom = nom;
    }

    public Demandeur() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        return this.nom;
    }
}
