package com.example.service.employee.Impl;

import com.example.model.employee.Position;
import com.example.repository.employee.IPositionRepository;
import com.example.service.employee.IPositionServie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PositionServiceImpl implements IPositionServie {

    @Autowired
    IPositionRepository positionRepository;
    @Override
    public List<Position> findAll() {
        return positionRepository.findAll();
    }
}
