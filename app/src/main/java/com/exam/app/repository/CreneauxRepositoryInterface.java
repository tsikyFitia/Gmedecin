package com.exam.app.repository;

import com.exam.app.entity.Creneaux;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface CreneauxRepositoryInterface extends CrudRepository<Creneaux, BigInteger> {
}
