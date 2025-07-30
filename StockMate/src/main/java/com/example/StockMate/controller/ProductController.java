package com.example.StockMate.controller;

import com.example.StockMate.controller.form.ProductForm;
import com.example.StockMate.service.StockWithProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProductController {

    @Autowired
    private StockWithProductService service;

    @GetMapping("/ProductDetails")
    public ModelAndView showProductDetails(@RequestParam("id") int productId) {
        ModelAndView mav = new ModelAndView();

        ProductForm productDetails;
        productDetails = service.getStockWithProductById(productId);

        mav.setViewName("productdetails");

        mav.addObject("product", productDetails);

        return mav;
    }

    @GetMapping("/EditProduct")
    public ModelAndView editProductDetails(@RequestParam("id") int productId) {
        ModelAndView mav = new ModelAndView();

        ProductForm product;
        product = service.getStockWithProductById(productId);

        mav.setViewName("editproduct");

        mav.addObject("product", product);

        return mav;
    }

    @PutMapping("/ProductUpdate/{id}")
    public ModelAndView productUpdate(@PathVariable Integer id, @ModelAttribute("product") ProductForm product){
        product.setId(id);
        service.saveProduct(product);

        ModelAndView mav = new ModelAndView();

        ProductForm productDetails;
        productDetails = service.getStockWithProductById(id);

        mav.setViewName("productdetails");

        mav.addObject("product", productDetails);

        return mav;
    }


}
