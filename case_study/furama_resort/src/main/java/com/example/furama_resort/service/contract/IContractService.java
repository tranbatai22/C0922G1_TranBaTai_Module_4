package com.example.furama_resort.service.contract;

import com.example.furama_resort.model.contract.Contract;

import java.util.List;

public interface IContractService {
    List<Contract> findAll();

    void save(Contract contract);
}
