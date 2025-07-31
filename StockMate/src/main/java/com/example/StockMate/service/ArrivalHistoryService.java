package com.example.StockMate.service;

import com.example.StockMate.repository.ArrivalRepository;
import com.example.StockMate.repository.entity.Arrival;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArrivalHistoryService {

    @Autowired
    ArrivalRepository arrivalRepository;

    public void recordArrival(int productId, int quantity) {
        Arrival arrival = new Arrival();
        arrival.setProductId(productId);
        arrival.setArrivalQuantity(quantity);
        arrivalRepository.save(arrival);
    }
}
