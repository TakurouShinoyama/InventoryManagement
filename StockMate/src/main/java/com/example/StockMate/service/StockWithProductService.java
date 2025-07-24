package com.example.StockMate.service;

import com.example.StockMate.controller.form.StockForm;
import com.example.StockMate.repository.StockRepository;
import com.example.StockMate.repository.entity.Product;
import com.example.StockMate.repository.entity.Stock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StockWithProductService {
    @Autowired
    StockRepository stockRepository;

    public List<StockForm> findAllStock() {
        List<Stock> results = stockRepository.findAll();
        List<StockForm> stocks = setStockForm(results);
        return stocks;
    }

    private List<StockForm> setStockForm(List<Stock> results) {
        List<StockForm> stocks = new ArrayList<>();

        for (int i = 0; i < results.size(); i++) {
            StockForm stock = new StockForm();
            Stock result = results.get(i);
            stock.setId(result.getId());
            //stock.setProductId(result.getProductId());
            stock.setStockQuantity(result.getStockQuantity());
            stocks.add(stock);
        }
        return stocks;
    }

    public List<StockForm> findAllStockWithProducts() {
        List<Stock> results = stockRepository.findAllWithProduct();
        return results.stream().map(this::convertToStockForm)
                .collect(Collectors.toList());
    }


    public List<Stock> getAllStocksWithProducts() {
        return stockRepository.findAllWithProduct();
    }

    private StockForm convertToStockForm(Stock stock) {
        StockForm form = new StockForm();
        form.setId(stock.getId());
        form.setStockQuantity(stock.getStockQuantity());

        if (stock.getProduct() != null) {
            Product product = stock.getProduct();
            form.setProductId(product.getId());
            form.setProductName(product.getName());
            form.setProductContents(product.getContents());
            form.setProductPrice(product.getPrice());
        }
        return form;
    }

    public Optional<StockForm> getStockWithProductById(int id) {
        return stockRepository.findByProductIdWithProduct(id)
                .map(this::convertToStockForm);
    }
}