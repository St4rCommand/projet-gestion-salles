package org.univ.salles.modele.entite;


import javax.persistence.*;

@Entity
@Table(name = "batiment")
public class Batiment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;

    public Batiment(String nom) {
        this.id = id;
        this.nom = nom;
    }

    public Batiment() {
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return this.nom;
    }
}
