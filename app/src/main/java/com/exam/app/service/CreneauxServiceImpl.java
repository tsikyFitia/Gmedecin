package com.exam.app.service;

import com.exam.app.entity.Creneaux;
import com.exam.app.repository.CreneauxRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public class CreneauxServiceImpl implements CreneauxServiceInterface{
    @Autowired
    private CreneauxRepositoryInterface creneauxRepository;

    @Override
    public Creneaux save(Creneaux creneau) {
        return creneauxRepository.save(creneau);
    }

    @Override
    public Creneaux findById(BigInteger id) {
        return creneauxRepository.findById(id).get();
    }

    @Override
    public List<Creneaux> read() {
        return (List<Creneaux>) creneauxRepository.findAll();
    }

    @Override
    public Creneaux update(Creneaux creneau, BigInteger id) {
        Creneaux cre = creneauxRepository.findById(id).get();

        if (creneau.getVersion()!= null && !creneau.getVersion().toString().isEmpty()) {
            cre.setVersion(creneau.getVersion());
        }

        if (creneau.getHdebut()!= null && !creneau.getHdebut().toString().isEmpty()) {
            cre.setHdebut(creneau.getHdebut());
        }

        if (creneau.getHfin()!= null && !creneau.getHfin().toString().isEmpty()) {
            cre.setHfin(creneau.getHfin());
        }

        if (creneau.getMdebut()!= null && !creneau.getMdebut().toString().isEmpty()) {
            cre.setMdebut(creneau.getMdebut());
        }

        if (creneau.getMfin()!= null && !creneau.getMfin().toString().isEmpty()) {
            cre.setMfin(creneau.getMfin());
        }
        return creneauxRepository.save(cre);
    }

    @Override
    public void delete(BigInteger id) {
        creneauxRepository.deleteById(id);
    }
}
