package com.example.service;

import com.example.model.Trade;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ITradeService {

    Page<Trade> findAllTrade(Pageable pageable, String keyword);

    void save(Trade trade);

    void delete(int id);

    Optional<Trade> findById(int id);
//
    List<Trade> findByName(String name);
//
//    List<Trade> findByFacility(String name);
}
