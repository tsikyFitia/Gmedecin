package com.exam.app.controller;

import com.exam.app.entity.Clients;
import com.exam.app.service.ClientsServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController
public class ClientsController {
    @Autowired private ClientsServiceInterface clientsService;
    @PostMapping("/client")
    public Clients save(@Validated @RequestBody Clients client)
    {
        return clientsService.save(client);
    }
    @GetMapping("/client")
    public List<Clients> read()
    {
        return clientsService.read();
    }
    @PutMapping("/client/{id}")
    public Clients update(@RequestBody Clients client, @PathVariable("id") BigInteger id){
        return clientsService.update(client, id);
    }

    @DeleteMapping("/client/{id}")
    public String delete(@PathVariable("id") BigInteger id){
        clientsService.delete(id);
        return "Delete Successfully";
    }
}
