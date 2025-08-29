package com.example.StockMate.controller;


import com.example.StockMate.controller.form.ArrivalForm;
import com.example.StockMate.controller.form.StockForm;
import com.example.StockMate.service.ArrivalService;
import com.example.StockMate.service.StockWithProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ArrivalController {
    @Autowired
    private StockWithProductService stockWithProductService;

    @Autowired
    private ArrivalService arrivalService;

    @GetMapping("/Arrival")
    public String showArrivalFrom(Model model) {

        if (!model.containsAttribute("arrivalForm")) {
            model.addAttribute("arrivalForm", new ArrivalForm());
        }

        List<StockForm> stocks = stockWithProductService.findAllStockWithProducts();

        model.addAttribute("stocks", stocks);

        return "arrival";
    }

    @PostMapping("/NewArrival")
    public String newArrival(
            @Valid @ModelAttribute("arrivalForm") ArrivalForm arrivalForm,
            BindingResult bindingResult,
            RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.arrivalForm", bindingResult);
            redirectAttributes.addFlashAttribute("arrivalForm", arrivalForm);
            return "redirect:/Arrival";
        }

        arrivalService.arrivalProcess(arrivalForm);

        String message = arrivalForm.getArrivalQuantity().toString() + "入荷しました。";

        redirectAttributes.addFlashAttribute("successMessage", message);

        return "redirect:/Arrival";
    }
}
