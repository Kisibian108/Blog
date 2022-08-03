package com.example.service.customer;

import com.example.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ICustomerService {

    Page<Customer> findAllCus(Pageable pageable, String keyword);

    void save(Customer customer);

    void delete(int id);

    Optional<Customer> findById(int id);

}
