package com.exam.app.controller;

import com.exam.app.entity.Clients;
import com.exam.app.entity.Creneaux;
import com.exam.app.entity.Medecins;
import com.exam.app.service.ClientsServiceInterface;
import com.exam.app.service.CreneauxServiceInterface;
import com.exam.app.service.MedecinsServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@Controller
@RequestMapping("/medecin")
public class CreneauxController {

    @Autowired
    private CreneauxServiceInterface creneauxService;
    @Autowired
    private ClientsServiceInterface clientsService;

    @Autowired
    private MedecinsServiceInterface medecinsService;

    @GetMapping("/")
    public String viewHomePage(Model model) {
        List<Creneaux> creneauxList = creneauxService.read();
        List<Clients> clientsList = clientsService.read();
        model.addAttribute("creneauxList", creneauxList);
        model.addAttribute("clientsList", clientsList);
        return "index";
    }

    @PostMapping("/creneau")
    @ResponseBody
    public Creneaux save(@Validated @RequestBody Creneaux creneau) {
        BigInteger idMedecin = creneau.getIdMedecin();
        Medecins medecin = medecinsService.findById(idMedecin);

        creneau.setIs_disponible(true);
        creneau.setMedecins(medecin);

        return creneauxService.save(creneau);
    }

    @GetMapping("/creneau")
    @ResponseBody
    public List<Creneaux> read() {
        return creneauxService.read();
    }

    @PutMapping("/creneau/{id}")
    @ResponseBody
    public Creneaux update(@RequestBody Creneaux creneau, @PathVariable("id") BigInteger id) {
        return creneauxService.update(creneau, id);
    }

    @DeleteMapping("/creneau/{id}")
    @ResponseBody
    public String delete(@PathVariable("id") BigInteger id) {
        creneauxService.delete(id);
        return "Delete Successfully";
    }
}

