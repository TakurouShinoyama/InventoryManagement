package com.example.StockMate.controller.form;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductForm {
    private int id;
    private String name;
    private String contents;
    private int price;
    private int stockQuantity;
}
