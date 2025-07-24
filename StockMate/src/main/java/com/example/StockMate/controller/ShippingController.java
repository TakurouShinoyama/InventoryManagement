package com.example.StockMate.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ShippingController {

    @GetMapping("/Shipping")
    public ModelAndView StockList() {
        ModelAndView mav = new ModelAndView();

//        List<StockForm> contentData = stockService.findAllStock();
//
        mav.setViewName("shipping");

//        mav.addObject("stocks", contentData);
        return mav;
    }
}
