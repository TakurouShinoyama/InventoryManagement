package com.example.StockMate.repository.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Table(name = "shipping")
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
public class Shipping {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "product_id")
    private int productId;

    @Column(name = "shipping_quantity")
    private int shippingQuantity;

    @Column(name = "address")
    private String address;

    @Column(name = "created_date", updatable = false)
    @CreatedDate
    private LocalDateTime createdDate;
}
