package com.example.StockMate.controller.form;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ArrivalForm {

    @NotNull(message = "商品を選択してください")
    private Integer productId;

    @NotNull(message = "入荷数を入力してくだい")
    @Min(value = 1, message = "入荷数は1以上で入力してください")
    private Integer arrivalQuantity;
}
