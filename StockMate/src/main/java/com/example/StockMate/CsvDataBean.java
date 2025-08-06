package com.example.StockMate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CsvDataBean {
    private Integer id;
    private String productName;
    private String productContents;
    private Integer stockQuantity;
}
