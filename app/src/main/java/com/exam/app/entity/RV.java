package com.exam.app.entity;

import jakarta.persistence.*;

import java.math.BigInteger;
import java.util.Date;

@Entity
public class RV {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "bigint(20)")
    private BigInteger id;

    @ManyToOne
    @JoinColumn(name = "id_client", nullable = false)
    private Clients client;

    @ManyToOne
    @JoinColumn(name = "id_creneau", nullable = false)
    private Creneaux creneau;

    private Date jour;

    @Transient // Ne pas persister ces champs dans la base de données
    private BigInteger idClient;

    @Transient
    private BigInteger idCreneau;

    public RV() {
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public Clients getClient() {
        return client;
    }

    public void setClient(Clients client) {
        this.client = client;
    }

    public Creneaux getCreneau() {
        return creneau;
    }

    public void setCreneau(Creneaux creneau) {
        this.creneau = creneau;
    }

    public Date getJour() {
        return jour;
    }

    public void setJour(Date jour) {
        this.jour = jour;
    }

    public BigInteger getIdClient() {
        return idClient;
    }

    public void setIdClient(BigInteger idClient) {
        this.idClient = idClient;
    }

    public BigInteger getIdCreneau() {
        return idCreneau;
    }

    public void setIdCreneau(BigInteger idCreneau) {
        this.idCreneau = idCreneau;
    }
}
