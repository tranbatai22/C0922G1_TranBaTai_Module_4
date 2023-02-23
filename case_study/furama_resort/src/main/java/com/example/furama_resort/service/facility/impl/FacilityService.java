package com.example.furama_resort.service.facility.impl;

import com.example.furama_resort.model.customer.Customer;
import com.example.furama_resort.model.facility.Facility;
import com.example.furama_resort.repository.facility.IFacilityRepository;
import com.example.furama_resort.service.facility.IFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FacilityService implements IFacilityService {
    @Autowired
    private IFacilityRepository facilityRepository;

    @Override
    public Page<Facility> search(String searchName, Pageable pageable) {
       return facilityRepository.search(searchName, pageable);
    }

    @Override
    public Page<Facility> search1(String searchName, String searchFacilityTypeName, Pageable pageable) {
        return facilityRepository.search1(searchName, searchFacilityTypeName, pageable);
    }

    @Override
    public void save(Facility facility) {
        facilityRepository.save(facility);
    }

    @Override
    public Optional<Facility> findById(int id) {
        return facilityRepository.findById(id);
    }

    @Override
    public List<Facility> findAll() {
        return facilityRepository.findAll();
    }

    @Override
    public void delete(int id) {
        facilityRepository.deleteById(id);
    }
}
