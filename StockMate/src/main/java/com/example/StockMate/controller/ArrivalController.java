package com.example.StockMate.controller;


import com.example.StockMate.controller.form.ArrivalForm;
import com.example.StockMate.controller.form.ProductForm;
import com.example.StockMate.controller.form.StockForm;
import com.example.StockMate.service.StockWithProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ArrivalController {
    @Autowired
    private StockWithProductService stockWithProductService;

    @GetMapping("/Arrival")
    public ModelAndView showArrivalFrom() {
        ModelAndView mav = new ModelAndView();

        List<StockForm> stocks = stockWithProductService.findAllStock();

        mav.setViewName("arrival");

        mav.addObject("stocks", stocks);

        mav.addObject("arrivalForm", new ArrivalForm());

        return mav;
    }

    @PostMapping("/NewArrival")
    public ModelAndView newArrival(@ModelAttribute("product") ProductForm product) {
        ModelAndView mav = new ModelAndView();


        return mav;
    }
}
