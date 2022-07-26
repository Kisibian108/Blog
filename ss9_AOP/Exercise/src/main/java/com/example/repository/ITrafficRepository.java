package com.example.repository;

import com.example.model.Traffic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITrafficRepository extends JpaRepository<Traffic,Integer> {
}
