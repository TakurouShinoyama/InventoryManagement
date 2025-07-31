package com.example.StockMate.repository.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Table(name = "arrival")
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
public class Arrival {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "product_id")
    private int productId;

    @Column(name = "arrival_quantity")
    private int arrivalQuantity;

    @Column(name = "created_date", updatable = false)
    @CreatedDate
    private LocalDateTime createdDate;
}
