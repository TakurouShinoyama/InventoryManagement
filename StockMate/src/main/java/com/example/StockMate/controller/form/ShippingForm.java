package com.example.StockMate.controller.form;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ShippingForm {
    private Integer productId;
    private Integer shippingQuantity;
    private String address;
}
