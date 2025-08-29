package com.example.StockMate.controller;

import com.example.StockMate.controller.form.ArrivalForm;
import com.example.StockMate.controller.form.ProductForm;
import com.example.StockMate.service.StockWithProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ProductController {

    @Autowired
    private StockWithProductService service;

    @GetMapping("/ProductDetails")
    public String showProductDetails(@RequestParam("id") int productId, Model model) {

        ProductForm productDetails = service.getStockWithProductById(productId);

        model.addAttribute("product", productDetails);

        return "productdetails";
    }

    @GetMapping("/EditProduct")
    public String editProductDetails(@RequestParam("id") int productId, Model model) {

        if (!model.containsAttribute("product")) {
            model.addAttribute("product", service.getStockWithProductById(productId));
        }

        return "editproduct";
    }

    @PutMapping("/ProductUpdate/{id}")
    public String productUpdate(
            @PathVariable Integer id,
            @Valid @ModelAttribute("product") ProductForm product,
            BindingResult bindingResult,
            RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.product", bindingResult);
            redirectAttributes.addFlashAttribute("product", product);
            return "redirect:/EditProduct?id=" + id;
        }

        product.setId(id);

        service.saveProduct(product);

        ProductForm productDetails;
        productDetails = service.getStockWithProductById(id);

        redirectAttributes.addFlashAttribute("product", productDetails);

        return "redirect:/ProductDetails?id=" + id;
    }
}
