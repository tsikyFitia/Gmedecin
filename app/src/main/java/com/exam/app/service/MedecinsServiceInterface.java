package com.exam.app.service;

import com.exam.app.entity.Medecins;

import java.math.BigInteger;
import java.util.List;

public interface MedecinsServiceInterface {
    Medecins save(Medecins medecin);
    Medecins findById(BigInteger id);
    List<Medecins> read();
    Medecins update(Medecins medecin, BigInteger id);
    void delete(BigInteger id);
}
