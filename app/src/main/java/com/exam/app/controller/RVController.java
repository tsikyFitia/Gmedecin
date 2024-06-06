package com.exam.app.controller;

import com.exam.app.entity.Clients;
import com.exam.app.entity.Creneaux;
import com.exam.app.entity.Medecins;
import com.exam.app.entity.RV;
import com.exam.app.service.ClientsServiceInterface;
import com.exam.app.service.CreneauxServiceInterface;
import com.exam.app.service.RVServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController
public class RVController {
    @Autowired
    private RVServiceInterface RVService;
    @Autowired
    private CreneauxServiceInterface creneauxService;

    @Autowired
    private ClientsServiceInterface clientsService;

    @PostMapping("/rv")
    public RV save(@Validated @RequestBody RV rv)
    {
        BigInteger idClient = rv.getIdClient();
        BigInteger idCreneau = rv.getIdCreneau();

        Clients client = clientsService.findById(idClient);
        Creneaux creneau = creneauxService.findById(idCreneau);
        rv.setClient((client));
        rv.setCreneau(creneau);
        return RVService.save(rv);
    }

    @GetMapping("/rv")
    public List<RV> read()
    {
        return RVService.read();
    }

    @PutMapping("/rv/{id}")
    public RV update(@RequestBody RV rv, @PathVariable("id") BigInteger id){
        return RVService.update(rv, id);
    }

    @DeleteMapping("/rv/{id}")
    public String delete(@PathVariable("id") BigInteger id){
        creneauxService.delete(id);
        return "Delete Successfully";
    }
}
