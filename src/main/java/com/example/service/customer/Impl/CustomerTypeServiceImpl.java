package com.example.service.customer.Impl;

import com.example.model.customer.CustomerType;
import com.example.repository.customer.ICustomerTypeRepository;
import com.example.service.customer.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class CustomerTypeServiceImpl implements ICustomerTypeService {

    @Autowired
    ICustomerTypeRepository customerTypeRepository;
    @Override
    public List<CustomerType> findAll() {
        return customerTypeRepository.findAll();
    }
}
