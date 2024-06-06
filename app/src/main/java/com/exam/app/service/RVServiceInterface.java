package com.exam.app.service;

import com.exam.app.entity.RV;

import java.math.BigInteger;
import java.util.List;

public interface RVServiceInterface {
    RV save(RV rv);
    List<RV> read();
    RV update(RV rv, BigInteger id);
    void delete(BigInteger id);
}
