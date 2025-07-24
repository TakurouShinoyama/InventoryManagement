package com.example.StockMate.controller;

import com.example.StockMate.controller.form.ProductForm;
import com.example.StockMate.service.StockWithProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProductController {

    @Autowired
    private StockWithProductService service;

    @GetMapping("/ProductDetails")
    public ModelAndView showProductDetails(@RequestParam("id") int productId) {
        ModelAndView mav = new ModelAndView();

        ProductForm product;
        product = service.getStockWithProductById(productId).get();
    }
}
