package com.example.repository;

import com.example.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IProductRepository extends JpaRepository<Product,Integer> {

    @Modifying
    @Transactional
    @Query(value = " delete from product p " +
            " where p.id = :id ", nativeQuery = true)
    void delete(@Param("id") int id);

    @Query(value = " select * " +
            " from product p where p.id = :id", nativeQuery = true)
    Product findById(@Param("id") int id);

    @Query(value = "select * from product where name = :keyword", nativeQuery = true)
    List<Product> searchByName(@Param("keyword") String name);

}
