package com.exam.app.entity;

import jakarta.persistence.*;

import java.math.BigInteger;

@Entity
public class Medecins {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "bigint(20)")
    private BigInteger id;
    @Version
    @Column(length = 11)
    private Integer version;
    @Column(length = 5)
    private String titre;
    @Column(length = 30)
    private String nom;
    @Column(length = 30)
    private String prenom;

    public Medecins(){}

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
}
