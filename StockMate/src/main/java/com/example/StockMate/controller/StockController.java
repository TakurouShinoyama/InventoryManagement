package com.example.StockMate.controller;

import com.example.StockMate.controller.form.StockForm;
import com.example.StockMate.service.StockWithProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class StockController {
    @Autowired
    private StockWithProductService stockWithProductService;

    @GetMapping("/StockList")
    public ModelAndView stockList() {
        ModelAndView mav = new ModelAndView();

        //List<StockForm> contentData = stockService.findAllStock();
        List<StockForm> contentData = stockWithProductService.findAllStockWithProducts();

        mav.setViewName("stocklist");

        mav.addObject("stocks", contentData);
        return mav;
    }

    @GetMapping("/NewProduct")
    public ModelAndView newProduct() {
        ModelAndView mav = new ModelAndView();

        List<StockForm> contentData = stockWithProductService.findAllStock();

        mav.setViewName("stocklist");

        mav.addObject("stocks", contentData);
        return mav;
    }
}
