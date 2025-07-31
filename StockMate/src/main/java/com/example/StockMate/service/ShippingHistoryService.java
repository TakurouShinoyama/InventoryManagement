package com.example.StockMate.service;

import com.example.StockMate.repository.ShippingRepository;
import com.example.StockMate.repository.entity.Shipping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShippingHistoryService {

    @Autowired
    ShippingRepository shippingRepository;

    public void recordShipping(int productId, int quantity, String address) {
        Shipping shipping = new Shipping();
        shipping.setProductId(productId);
        shipping.setShippingQuantity(quantity);
        shipping.setAddress(address);
        shippingRepository.save(shipping);
    }
}
