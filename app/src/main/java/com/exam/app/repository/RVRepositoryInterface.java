package com.exam.app.repository;
import com.exam.app.entity.RV;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface RVRepositoryInterface extends CrudRepository<RV, BigInteger> {
}
