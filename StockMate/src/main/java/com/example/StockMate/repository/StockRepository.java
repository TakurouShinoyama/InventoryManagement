package com.example.StockMate.repository;

import com.example.StockMate.repository.entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StockRepository extends JpaRepository<Stock, Integer> {

    @Query("SELECT s FROM Stock s JOIN FETCH s.product ORDER BY s.id DESC")
    List<Stock> findAllWithProduct();

    @Query("SELECT s FROM Stock s JOIN FETCH s.product WHERE s.id = :id")
    Optional<Stock> findByIdWithProduct(Integer id);

    @Query("SELECT s FROM Stock s JOIN FETCH s.product WHERE s.product.id = :productId")
    Optional<Stock> findByProductIdWithProduct(int productId);
}
