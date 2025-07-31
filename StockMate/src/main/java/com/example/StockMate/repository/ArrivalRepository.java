package com.example.StockMate.repository;

import com.example.StockMate.repository.entity.Arrival;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArrivalRepository extends JpaRepository<Arrival, Integer> {
}
