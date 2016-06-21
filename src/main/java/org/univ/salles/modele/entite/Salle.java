package org.univ.salles.modele.entite;

import javax.persistence.*;

@Entity
@Table(name = "salle")
public class Salle {

    @Id
    private Integer noSalle;
    private Integer noEtage;
    private Integer superficie;
    @ManyToOne
    private Batiment batiment;
    @ManyToOne
    private TypeSalle type;

    public Salle(Integer noSalle, Integer noEtage, Integer superficie, Batiment batiment, TypeSalle type) {
        this.noSalle = noSalle;
        this.noEtage = noEtage;
        this.superficie = superficie;
        this.batiment = batiment;
        this.type = type;
    }

    public Salle() {
    }

    public Integer getNoSalle() {
        return noSalle;
    }

    public void setNoSalle(Integer noSalle) {
        this.noSalle = noSalle;
    }

    public Integer getNoEtage() {
        return noEtage;
    }

    public void setNoEtage(Integer noEtage) {
        this.noEtage = noEtage;
    }

    public Integer getSuperficie() {
        return superficie;
    }

    public void setSuperficie(Integer superficie) {
        this.superficie = superficie;
    }

    public Batiment getBatiment() {
        return batiment;
    }

    public void setBatiment(Batiment batiment) {
        this.batiment = batiment;
    }

    public TypeSalle getType() {
        return type;
    }

    public void setType(TypeSalle type) {
        this.type = type;
    }

    public String toString() {
        return this.noSalle + " (" + this.batiment.getNom() + ")";
    }
}
