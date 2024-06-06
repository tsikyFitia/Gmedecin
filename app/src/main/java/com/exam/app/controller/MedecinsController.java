package com.exam.app.controller;

import com.exam.app.entity.Medecins;
import com.exam.app.service.MedecinsServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController
public class MedecinsController {
    @Autowired private MedecinsServiceInterface medecinsService;
    @PostMapping("/medecin")
    public Medecins save(@Validated @RequestBody Medecins medecins)
    {
        return medecinsService.save(medecins);
    }
    @GetMapping("/medecin")
    public List<Medecins> read()
    {
        return medecinsService.read();
    }
    @PutMapping("/medecin/{id}")
    public Medecins update(@RequestBody Medecins medecin, @PathVariable("id") BigInteger id){
        return medecinsService.update(medecin, id);
    }

    @DeleteMapping("/medecin/{id}")
    public String delete(@PathVariable("id") BigInteger id){
        medecinsService.delete(id);
        return "Delete Successfully";
    }
}
