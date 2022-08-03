package com.example.service.facility.Impl;

import com.example.model.facility.RentType;
import com.example.repository.facility.IRentTypeRepository;
import com.example.service.facility.IRentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentTypeServiceImpl implements IRentTypeService {

    @Autowired
    IRentTypeRepository rentTypeRepository;

    @Override
    public List<RentType> findAll() {
        return rentTypeRepository.findAll();
    }
}
