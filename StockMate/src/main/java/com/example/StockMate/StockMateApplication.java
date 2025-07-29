package com.example.StockMate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class StockMateApplication {

	public static void main(String[] args) {
		SpringApplication.run(StockMateApplication.class, args);
	}

}
