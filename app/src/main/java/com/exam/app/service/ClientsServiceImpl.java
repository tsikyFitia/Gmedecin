package com.exam.app.service;

import com.exam.app.entity.Clients;
import com.exam.app.repository.ClientsRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.Objects;

@Service
public class ClientsServiceImpl implements ClientsServiceInterface{
    @Autowired
    private ClientsRepositoryInterface clientsRepository;
    @Override
    public Clients save(Clients clients) {
        return clientsRepository.save(clients);
    }

    @Override
    public Clients findById(BigInteger id) {
        return clientsRepository.findById(id).get();
    }

    @Override
    public List<Clients> read() {
        return (List<Clients>) clientsRepository.findAll();
    }

    @Override
    public Clients update(Clients clients, BigInteger id) {
        Clients cli = clientsRepository.findById(id).get();
        if(Objects.nonNull(clients.getNom()) && ! "".equalsIgnoreCase(clients.getNom())){
            cli.setNom(clients.getNom());
        }
        if(Objects.nonNull(clients.getPrenom()) && ! "".equalsIgnoreCase(clients.getPrenom())){
            cli.setPrenom(clients.getPrenom());
        }
        if (clients.getVersion()!= null && !clients.getVersion().toString().isEmpty()) {
            cli.setVersion(clients.getVersion());
        }
        if(Objects.nonNull(clients.getTitre()) && ! "".equalsIgnoreCase(clients.getTitre())){
            cli.setTitre(clients.getTitre());
        }

        return clientsRepository.save(cli);
    }

    @Override
    public void delete(BigInteger id) {
        clientsRepository.deleteById(id);
    }
}
