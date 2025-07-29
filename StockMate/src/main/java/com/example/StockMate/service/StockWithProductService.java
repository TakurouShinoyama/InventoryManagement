package com.example.StockMate.service;

import com.example.StockMate.controller.form.ProductForm;
import com.example.StockMate.controller.form.StockForm;
import com.example.StockMate.repository.ProductRepository;
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

    @Autowired
    ProductRepository productRepository;

    public List<StockForm> findAllStock() {
        List<Stock> results = stockRepository.findAll();
        return setStockForm(results);
    }

    private List<StockForm> setStockForm(List<Stock> results) {
        List<StockForm> stocks = new ArrayList<>();

        for (Stock value : results) {
            StockForm stock = new StockForm();
            stock.setId(value.getId());
            //stock.setProductId(result.getProductId());
            stock.setStockQuantity(value.getStockQuantity());
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

    private ProductForm convertToProductForm(Stock stock) {
        ProductForm form = new ProductForm();

        form.setId(stock.getProduct().getId());
        form.setName(stock.getProduct().getName());
        form.setContents(stock.getProduct().getContents());
        form.setPrice(stock.getProduct().getPrice());
        form.setStockQuantity(stock.getStockQuantity());

        return form;
    }

    public ProductForm getStockWithProductById(int id) {
        Optional<Stock> stocks = stockRepository.findByProductIdWithProduct(id);
        return convertToProductForm(stocks.get());
    }

    public void saveProduct(ProductForm form) {
        productRepository.save(setProductEntity(form));
    }

    private Product setProductEntity(ProductForm form) {
        Product product = new Product();
        product.setId(form.getId());
        product.setName(form.getName());
        product.setContents(form.getContents());
        product.setPrice(form.getPrice());
        return product;
    }
}