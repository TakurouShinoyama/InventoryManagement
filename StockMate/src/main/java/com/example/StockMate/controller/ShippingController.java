package com.example.StockMate.controller;

import com.example.StockMate.controller.form.ArrivalForm;
import com.example.StockMate.controller.form.ShippingForm;
import com.example.StockMate.controller.form.StockForm;
import com.example.StockMate.service.ShippingService;
import com.example.StockMate.service.StockWithProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ShippingController {

    @Autowired
    private StockWithProductService stockWithProductService;

    @Autowired
    private ShippingService shippingService;

    @GetMapping("/Shipping")
    public ModelAndView showShippingFrom() {
        ModelAndView mav = new ModelAndView();

        List<StockForm> stocks = stockWithProductService.findAllStockWithProducts();

        mav.setViewName("shipping");

        mav.addObject("stocks", stocks);

        mav.addObject("shippingForm", new ShippingForm());

        return mav;
    }

    @PostMapping("/NewShipping")
    public String newArrival(@ModelAttribute("shippingForm") ShippingForm shippingForm, RedirectAttributes redirectAttributes) {

        shippingService.shippingProcess(shippingForm);

        String message = shippingForm.getShippingQuantity().toString() + "出荷しました。";

        redirectAttributes.addFlashAttribute("successMessage", message);

        return "redirect:/Arrival";
    }
}
