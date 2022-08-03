package com.example.service.facility;

import com.example.model.facility.FacilityType;
import com.example.model.facility.RentType;

import java.util.List;

public interface IRentTypeService {
    List<RentType> findAll();
}
