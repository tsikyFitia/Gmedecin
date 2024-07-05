package com.exam.app.controller;

import com.exam.app.entity.Medecins;
import com.exam.app.service.MedecinsServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class MedecinsController {
    @Autowired
    private MedecinsServiceInterface medecinsService;

    @PostMapping("/medecin")
    public String save(@Validated @ModelAttribute Medecins medecin) {
        medecinsService.save(medecin);
        return "redirect:/medecin";
    }

    @PostMapping("/medecin/{id}")
    public String update(@Validated @ModelAttribute Medecins medecin, @PathVariable("id") BigInteger id) {
        medecinsService.update(medecin, id);
        return "redirect:/medecin";
    }

    @DeleteMapping("/medecin/{id}")
    @ResponseBody
    public String delete(@PathVariable("id") BigInteger id) {
        medecinsService.delete(id);
        return "redirect:/medecin";
    }

    @GetMapping("/medecin")
    public String viewHomePage(Model model) {
        List<Medecins> medecinsList = medecinsService.read();
        model.addAttribute("medecinsList", medecinsList);
        model.addAttribute("newMedecin", new Medecins()); // For the form
        return "medecin";
    }
}

