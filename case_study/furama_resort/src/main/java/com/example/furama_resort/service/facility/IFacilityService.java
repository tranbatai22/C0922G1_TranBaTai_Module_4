package com.example.furama_resort.service.facility;

import com.example.furama_resort.model.customer.Customer;
import com.example.furama_resort.model.facility.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IFacilityService {
    Page<Facility> search(String searchName, Pageable pageable);

    Page<Facility> search1(String searchName,String searchFacilityTypeName, Pageable pageable);

    void save(Facility facility);

    Optional<Facility> findById(int id);

    List<Facility> findAll();

    void delete(int id);
}
