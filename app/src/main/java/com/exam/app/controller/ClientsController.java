package com.exam.app.controller;

import com.exam.app.entity.Clients;
import com.exam.app.service.ClientsServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class ClientsController {
    @Autowired private ClientsServiceInterface clientsService;

    @PostMapping("/client")
    public String save(@Validated @ModelAttribute Clients client)
    {

        clientsService.save(client);
        return "redirect:/client";
    }

    @PostMapping("/client/{id}")
    public String update( @ModelAttribute Clients client, @PathVariable("id") BigInteger id){
        clientsService.update(client, id);
        return "redirect:/client";
    }

    @DeleteMapping("/client/{id}")
    @ResponseBody
    public String delete(@PathVariable("id") BigInteger id){
        clientsService.delete(id);
        return "redirect:/client";
    }

    @GetMapping("/client")
    public String viewHomePage(Model model) {
        List<Clients> clientsList = clientsService.read();
        model.addAttribute("clientsList", clientsList);
        model.addAttribute("newClient", new Clients()); // For the form
        return "client";
    }
}
