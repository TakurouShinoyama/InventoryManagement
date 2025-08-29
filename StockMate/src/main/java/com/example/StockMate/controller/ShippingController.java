package com.example.StockMate.controller;

import com.example.StockMate.controller.form.ArrivalForm;
import com.example.StockMate.controller.form.ProductForm;
import com.example.StockMate.controller.form.ShippingForm;
import com.example.StockMate.controller.form.StockForm;
import com.example.StockMate.service.ShippingService;
import com.example.StockMate.service.StockWithProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
    public String showShippingFrom(Model model) {

        if (!model.containsAttribute("shippingForm")) {
            model.addAttribute("shippingForm", new ShippingForm());
        }

        List<StockForm> stocks = stockWithProductService.findAllStockWithProducts();

        model.addAttribute("stocks", stocks);

        return "Shipping";
    }

    @PostMapping("/NewShipping")
    public String newArrival(
            @Valid @ModelAttribute("shippingForm") ShippingForm shippingForm,
            BindingResult bindingResult,
            RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.shippingForm", bindingResult);
            redirectAttributes.addFlashAttribute("shippingForm", shippingForm);
            return "redirect:/Shipping";
        }

        shippingService.shippingProcess(shippingForm);

        String message = shippingForm.getShippingQuantity().toString() + "出荷しました。";

        redirectAttributes.addFlashAttribute("successMessage", message);

        return "redirect:/Shipping";
    }
}
