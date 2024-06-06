package com.exam.app.service;

import com.exam.app.entity.Medecins;
import com.exam.app.repository.MedecinsRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.Objects;

@Service
public class MedecinsServiceImpl implements MedecinsServiceInterface{
    @Autowired
    private MedecinsRepositoryInterface medecinsRepository;
    @Override
    public Medecins save(Medecins medecin) {
        return medecinsRepository.save(medecin);
    }

    @Override
    public List<Medecins> read() {
        return (List<Medecins>) medecinsRepository.findAll();
    }

    @Override
    public Medecins update(Medecins medecin, BigInteger id) {
        Medecins med = medecinsRepository.findById(id).get();
        if(Objects.nonNull(medecin.getNom()) && ! "".equalsIgnoreCase(medecin.getNom())){
            med.setNom(medecin.getNom());
        }
        if(Objects.nonNull(medecin.getPrenom()) && ! "".equalsIgnoreCase(medecin.getPrenom())){
            med.setPrenom(medecin.getPrenom());
        }
        if (medecin.getVersion()!= null && !medecin.getVersion().toString().isEmpty()) {
            med.setVersion(medecin.getVersion());
        }
        if(Objects.nonNull(medecin.getTitre()) && ! "".equalsIgnoreCase(medecin.getTitre())){
            med.setTitre(medecin.getTitre());
        }

        return medecinsRepository.save(med);
    }

    @Override
    public void delete(BigInteger id) {
        medecinsRepository.deleteById(id);
    }

    public Medecins findById(BigInteger id){
        return medecinsRepository.findById(id).get();
    }
}
