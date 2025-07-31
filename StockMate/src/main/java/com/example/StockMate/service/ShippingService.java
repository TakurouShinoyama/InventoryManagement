package com.example.StockMate.service;

import com.example.StockMate.controller.form.ArrivalForm;
import com.example.StockMate.controller.form.ShippingForm;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShippingService {

    @Autowired
    private ShippingHistoryService shippingHistoryService;

    @Autowired
    private StockService stockService;

    @Transactional
    public void shippingProcess(ShippingForm from) {
        stockService.removeStock(from.getProductId(), from.getShippingQuantity());
        shippingHistoryService.recordShipping(from.getProductId(), from.getShippingQuantity(), from.getAddress());
    }
}
