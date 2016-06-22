package org.univ.salles.modele.entite;

import javax.persistence.*;

@Entity
@Table(name = "materiel")
public class Materiel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;

    public Materiel(String nom) {
        this.nom = nom;
    }

    public Materiel() {
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

    public String toString() {
        return this.nom;
    }
}
