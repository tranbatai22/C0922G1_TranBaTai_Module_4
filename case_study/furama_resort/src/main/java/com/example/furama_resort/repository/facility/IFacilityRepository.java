package com.example.furama_resort.repository.facility;

import com.example.furama_resort.model.customer.Customer;
import com.example.furama_resort.model.facility.Facility;
import com.example.furama_resort.service.facility.impl.FacilityService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IFacilityRepository extends JpaRepository<Facility, Integer> {
    @Query(value = "select * from facility where name like %:searchName%", nativeQuery = true)
    Page<Facility> search(@Param("searchName") String searchName, Pageable pageable);

    @Query(value = "select f.* from `facility` f join `facility_type` ft on f.facility_type_id = f.facility_type_id  where f.name like %:searchName% and ft.facility_type_name = :searchFacilityTypeName" ,nativeQuery = true )
    Page<Facility> search1(@Param("searchName") String searchName,@Param("searchFacilityTypeName") String searchFacilityTypeName,  Pageable pageable);

}
