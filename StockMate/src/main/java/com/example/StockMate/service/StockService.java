package com.example.StockMate.service;

import com.example.StockMate.repository.StockRepository;
import com.example.StockMate.repository.entity.Product;
import com.example.StockMate.repository.entity.Stock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StockService {

    @Autowired
    StockRepository stockRepository;

    public void increaseStock(int productId, int quantity) {
        Stock product = stockRepository.findByProductIdWithProduct(productId).get();
        product.setStockQuantity(product.getStockQuantity() + quantity);
        stockRepository.save(product);
    }

    public void removeStock(int productId, int quantity) {
        Stock product = stockRepository.findByProductIdWithProduct(productId).get();
        product.setStockQuantity(product.getStockQuantity() - quantity);
        stockRepository.save(product);
    }
}
