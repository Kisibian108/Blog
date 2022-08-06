package com.example.repository;

import com.example.model.Trade;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ITradeRepository extends JpaRepository<Trade,Integer> {

    @Query(value = " select * from trade join customer on customer.id = trade.customer_id where `name` like :keyword or service_type like :keyword ", nativeQuery = true,
            countQuery = " select count(*) from (select customer.name from trade join customer on customer.id = trade.customer_id where `name` like :keyword or service_type like :keyword ) temp_table ")
    Page<Trade> findAllTrade(@Param("keyword") String keyword , Pageable pageable);

}
