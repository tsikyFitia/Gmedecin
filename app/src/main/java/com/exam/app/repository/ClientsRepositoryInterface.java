package com.exam.app.repository;

import com.exam.app.entity.Clients;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface ClientsRepositoryInterface extends CrudRepository<Clients, BigInteger> {
}
