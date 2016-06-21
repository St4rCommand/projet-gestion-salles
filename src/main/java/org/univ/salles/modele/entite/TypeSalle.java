package org.univ.salles.modele.entite;

import javax.persistence.*;

@Entity
@Table(name = "typeSalle")
public class TypeSalle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String libelle;

    public TypeSalle(String libelle) {
        this.libelle = libelle;
    }

    public TypeSalle() {
    }

    public Long getNoSalle() {
        return id;
    }

    public void setNoSalle(Long noSalle) {
        this.id = noSalle;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    @Override
    public String toString() {
        return this.libelle;
    }
}
