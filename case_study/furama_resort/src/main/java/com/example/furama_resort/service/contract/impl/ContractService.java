package com.example.furama_resort.service.contract.impl;

import com.example.furama_resort.model.contract.Contract;
import com.example.furama_resort.repository.contract.IContractRepository;
import com.example.furama_resort.service.contract.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractService implements IContractService {
    @Autowired
    private IContractRepository contractRepository;
    @Override
    public List<Contract> findAll() {
        return contractRepository.findAll();
    }

    @Override
    public void save(Contract contract) {
        contractRepository.save(contract);
    }
}
