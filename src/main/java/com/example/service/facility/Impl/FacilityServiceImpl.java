package com.example.service.facility.Impl;

import com.example.model.facility.Facility;
import com.example.repository.facility.IFacilityRepository;
import com.example.service.facility.IFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FacilityServiceImpl implements IFacilityService {

    @Autowired
    IFacilityRepository facilityRepository;

    @Override
    public Page<Facility> findAllFacility(Pageable pageable, String keyword) {
        return facilityRepository.findAllFacility("%" + keyword + "%", pageable);
    }

    @Override
    public void save(Facility facility) {
        facilityRepository.save(facility);
    }

    @Override
    public void delete(int id) {
        facilityRepository.deleteById(id);
    }

    @Override
    public Optional<Facility> findById(int id) {
        return facilityRepository.findById(id);
    }
}
