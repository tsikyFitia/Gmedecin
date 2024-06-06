package com.exam.app.controller;

import com.exam.app.entity.Creneaux;
import com.exam.app.entity.Medecins;
import com.exam.app.service.CreneauxServiceInterface;
import com.exam.app.service.MedecinsServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController
public class CreneauxController {
    @Autowired
    private CreneauxServiceInterface creneauxService;
    @Autowired
    private MedecinsServiceInterface medecinsService;
    @PostMapping("/creneau")
    public Creneaux save(@Validated @RequestBody Creneaux creneau, @RequestParam("id_medecin") BigInteger id_medecin)
    {
        Medecins medecin = medecinsService.findById(id_medecin);
        creneau.setMedecins((medecin));
        return creneauxService.save(creneau);
    }

    @GetMapping("/creneau")
    public List<Creneaux> read()
    {
        return creneauxService.read();
    }

    @PutMapping("/creneau/{id}")
    public Creneaux update(@RequestBody Creneaux creneau, @PathVariable("id") BigInteger id){
        return creneauxService.update(creneau, id);
    }

    @DeleteMapping("/creneau/{id}")
    public String delete(@PathVariable("id") BigInteger id){
        creneauxService.delete(id);
        return "Delete Successfully";
    }
}
