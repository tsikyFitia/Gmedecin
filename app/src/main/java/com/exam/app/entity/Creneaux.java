package com.exam.app.entity;

import jakarta.persistence.*;

import java.math.BigInteger;

@Entity
public class Creneaux {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "bigint(20)")
    private BigInteger id;
    @ManyToOne
    @JoinColumn(name = "id_medecin", nullable = false)
    private Medecins medecins;

    @Column(length = 11)
    private Integer version;
    @Column(length = 11)
    private Integer hdebut;
    @Column(length = 11)
    private  Integer mdebut;
    @Column(length = 11)
    private Integer hfin;
    @Column(length = 11)
    private Integer mfin;

    public Creneaux() {
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public Medecins getMedecins() {
        return medecins;
    }

    public void setMedecins(Medecins medecins) {
        this.medecins = medecins;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Integer getHdebut() {
        return hdebut;
    }

    public void setHdebut(Integer hdebut) {
        this.hdebut = hdebut;
    }

    public Integer getMdebut() {
        return mdebut;
    }

    public void setMdebut(Integer mdebut) {
        this.mdebut = mdebut;
    }

    public Integer getHfin() {
        return hfin;
    }

    public void setHfin(Integer hfin) {
        this.hfin = hfin;
    }

    public Integer getMfin() {
        return mfin;
    }

    public void setMfin(Integer mfin) {
        this.mfin = mfin;
    }
}
