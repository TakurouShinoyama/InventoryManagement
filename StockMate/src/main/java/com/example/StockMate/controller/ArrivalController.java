package com.example.StockMate.controller;


import com.example.StockMate.controller.form.StockForm;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ArrivalController {

    @GetMapping("/Arrival")
    public ModelAndView StockList() {
        ModelAndView mav = new ModelAndView();

//        List<StockForm> contentData = stockService.findAllStock();
        mav.setViewName("arrival");

//        mav.addObject("stocks", contentData);
        return mav;
    }
}
