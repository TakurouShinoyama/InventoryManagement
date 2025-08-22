package com.example.StockMate.controller.form;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductForm {
    private int id;

    @NotBlank(message = "商品名を入力してください")
    @Size(max = 20, message = "商品名は20文字以下で入力してください")
    private String name;

    private String contents;

    @NotNull(message = "単価を入力してください")
    @Min(value = 1, message = "単価は0以上で入力してください")
    private int price;

    private int stockQuantity;
}
