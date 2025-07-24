package com.example.StockMate.controller.form;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StockForm {
    private int id;
    private int stockQuantity;
    private int productId;
    private String productName;
    private String productContents;
    private int productPrice;
}
