package com.example.StockMate.controller.form;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ShippingForm {

    @NotNull(message = "商品を選択してください")
    private Integer productId;

    @NotNull(message = "出荷数を入力してくだい")
    @Min(value = 1, message = "出荷数は1以上で入力してください")
    private Integer shippingQuantity;

    private String address;
}
