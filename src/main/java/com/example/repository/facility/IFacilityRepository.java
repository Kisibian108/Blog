package com.example.repository.facility;

import com.example.model.customer.Customer;
import com.example.model.facility.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IFacilityRepository extends JpaRepository<Facility,Integer> {

    @Query(value = " select * from facility where name like :keyword ", nativeQuery = true,
            countQuery = " select count(*) from (select * from facility where name like :keyword ) temp_table ")
    Page<Facility> findAllFacility(@Param("keyword") String keyword , Pageable pageable);
}
