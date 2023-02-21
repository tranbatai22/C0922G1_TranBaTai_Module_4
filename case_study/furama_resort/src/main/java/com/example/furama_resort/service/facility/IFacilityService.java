package com.example.furama_resort.service.facility;

import com.example.furama_resort.model.customer.Customer;
import com.example.furama_resort.model.facility.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IFacilityService {
    Page<Facility> search(String searchName, Pageable pageable);

    void save(Facility facility);
}
