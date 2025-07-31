package com.example.StockMate.service;

import com.example.StockMate.controller.form.ArrivalForm;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.beans.Transient;

@Service
public class ArrivalService {

    @Autowired
    private ArrivalHistoryService arrivalHistoryService;

    @Autowired
    private StockService stockService;

    @Transactional
    public void arrivalProcess(ArrivalForm from) {
        stockService.increaseStock(from.getProductId(), from.getArrivalQuantity());
        arrivalHistoryService.recordArrival(from.getProductId(), from.getArrivalQuantity());
    }
}
