package com.exam.app.service;

import com.exam.app.entity.Creneaux;
import com.exam.app.entity.Medecins;

import java.math.BigInteger;
import java.util.List;

public interface CreneauxServiceInterface {
    Creneaux save(Creneaux creneau);
    Creneaux findById(BigInteger id);
    List<Creneaux> read();
    Creneaux update(Creneaux creneau, BigInteger id);
    void delete(BigInteger id);
}
