package com.exam.app.repository;

import com.exam.app.entity.Medecins;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface MedecinsRepositoryInterface extends CrudRepository<Medecins, BigInteger> {
}
