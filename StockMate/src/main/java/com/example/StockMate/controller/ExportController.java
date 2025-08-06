package com.example.StockMate.controller;

import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.example.StockMate.CsvDataBean;
import com.example.StockMate.service.StockWithProductService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.PrintWriter;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Controller
public class ExportController {

    @Autowired
    private StockWithProductService stockWithProductService;

    @GetMapping("/Export")
    public void ExportCsv(HttpServletResponse response) {
        try {
            String fileName = "stock_data.csv";
            response.setContentType("text/csv; charset=UTF-8");

            String encodedFileName = URLEncoder.encode(fileName, StandardCharsets.UTF_8);
            String headerValue = String.format("attachment; filename=\"%s\"", encodedFileName);
            response.setHeader("Content-Disposition", headerValue);

            response.setCharacterEncoding("UTF-8");
            PrintWriter writer = response.getWriter();
            writer.write('\uFEFF');

            List<CsvDataBean> dataList = stockWithProductService.findAllForCsv();

            StatefulBeanToCsv<CsvDataBean> beanToCsv = new StatefulBeanToCsvBuilder<CsvDataBean>(writer)
                    .withApplyQuotesToAll(false)
                    .build();
            beanToCsv.write(dataList);
        } catch (Exception e) {
            // エラー処理
            e.printStackTrace();
        }
    }
}
