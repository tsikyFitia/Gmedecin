package com.exam.app.service;
import com.exam.app.entity.RV;
import com.exam.app.repository.RVRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.Objects;

@Service
public class RVServiceImpl implements RVServiceInterface{
    @Autowired
    private RVRepositoryInterface RVRepository;

    @Override
    public RV save(RV rv) {
        return RVRepository.save(rv);
    }

    @Override
    public List<RV> read() {
        return (List<RV>) RVRepository.findAll();
    }

    @Override
    public RV update(RV rv, BigInteger id) {
        RV rvf = RVRepository.findById(id).get();

        if(Objects.nonNull(rv.getJour()) ){
            rvf.setJour(rv.getJour());
        }
        return RVRepository.save(rvf);
    }

    @Override
    public void delete(BigInteger id) {
        RVRepository.deleteById(id);
    }
}
