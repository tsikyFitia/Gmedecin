package com.exam.app.service;

import com.exam.app.entity.Clients;
import com.exam.app.entity.Creneaux;

import java.math.BigInteger;
import java.util.List;

public interface ClientsServiceInterface {
    Clients save(Clients clients);

    Clients findById(BigInteger id);
    List<Clients> read();
    Clients update(Clients clients, BigInteger id);
    void delete(BigInteger id);
}
