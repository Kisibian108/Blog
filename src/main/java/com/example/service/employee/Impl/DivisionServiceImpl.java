package com.example.service.employee.Impl;

import com.example.model.employee.Division;
import com.example.repository.employee.IDisivionRepository;
import com.example.service.employee.IDivisionServie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DivisionServiceImpl implements IDivisionServie {

    @Autowired
    IDisivionRepository disivionRepository;

    @Override
    public List<Division> findAll() {
        return disivionRepository.findAll();
    }
}
