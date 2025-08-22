package com.example.StockMate.controller;

import com.example.StockMate.controller.form.ProductForm;
import com.example.StockMate.controller.form.StockForm;
import com.example.StockMate.service.StockWithProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    public String newProduct(Model model) {

        if (!model.containsAttribute("product")) {
            model.addAttribute("product", new ProductForm());
        }

        return "newproduct";
    }

    @PostMapping("/ProductCreate")
    public String productCreate(
            @Valid @ModelAttribute("product") ProductForm product,
            BindingResult bindingResult,
            RedirectAttributes redirectAttributes){

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.product", bindingResult);
            redirectAttributes.addFlashAttribute("product", product);
            return "redirect:/NewProduct";
        }

        stockWithProductService.createProduct(product);

        redirectAttributes.addFlashAttribute("successMessage", "商品を登録しました。");
        return "redirect:/StockList";
    }
}
