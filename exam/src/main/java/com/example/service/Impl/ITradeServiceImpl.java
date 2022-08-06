package com.example.service.Impl;

import com.example.model.Trade;
import com.example.repository.ITradeRepository;
import com.example.service.ITradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ITradeServiceImpl implements ITradeService {

    @Autowired
    ITradeRepository tradeRepository;

    @Override
    public Page<Trade> findAllTrade(Pageable pageable, String keyword) {
        return tradeRepository.findAllTrade("%" + keyword + "%",pageable);
    }

    @Override
    public void save(Trade trade) {
        tradeRepository.save(trade);
    }

    @Override
    public void delete(int id) {
        tradeRepository.deleteById(id);
    }

    @Override
    public Optional<Trade> findById(int id) {
        return tradeRepository.findById(id);
    }

    @Override
    public List<Trade> findByName(String name) {
        return null;
    }

//
//    @Override
//    public List<Trade> findByFacility(String name) {
//        return tradeRepository.findTradeByServiceType();
//    }
}
