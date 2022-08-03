package com.example.service.facility.Impl;

import com.example.model.facility.FacilityType;
import com.example.repository.facility.IFacilityRepository;
import com.example.repository.facility.IFacilityTypeRepository;
import com.example.service.facility.IFacilityTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacilityTypeServiceImpl implements IFacilityTypeService {

    @Autowired
    IFacilityTypeRepository facilityTypeRepository;
    @Override
    public List<FacilityType> findAll() {
        return facilityTypeRepository.findAll();
    }
}
