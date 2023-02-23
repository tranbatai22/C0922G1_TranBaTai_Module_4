package com.example.furama_resort.repository.contract;

import com.example.furama_resort.model.contract.Contract;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IContractRepository extends JpaRepository<Contract, Integer> {
}
