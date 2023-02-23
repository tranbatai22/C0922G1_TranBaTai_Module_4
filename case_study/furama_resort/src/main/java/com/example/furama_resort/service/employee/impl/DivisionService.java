package com.example.furama_resort.service.employee.impl;

import com.example.furama_resort.model.employee.Division;
import com.example.furama_resort.repository.employee.IDivisionRepository;
import com.example.furama_resort.service.employee.IDivisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DivisionService implements IDivisionService {
    @Autowired
    private IDivisionRepository divisionRepository;
    @Override
    public List<Division> findAll() {
        return divisionRepository.findAll();
    }
}
