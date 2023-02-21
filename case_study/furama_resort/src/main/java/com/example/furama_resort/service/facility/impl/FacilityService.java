package com.example.furama_resort.service.facility.impl;

import com.example.furama_resort.model.customer.Customer;
import com.example.furama_resort.model.facility.Facility;
import com.example.furama_resort.repository.facility.IFacilityRepository;
import com.example.furama_resort.service.facility.IFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class FacilityService implements IFacilityService {
    @Autowired
    private IFacilityRepository facilityRepository;

    @Override
    public Page<Facility> search(String searchName, Pageable pageable) {
       return facilityRepository.search(searchName, pageable);
    }

    @Override
    public void save(Facility facility) {
        facilityRepository.save(facility);
    }
}
