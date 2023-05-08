package com.group08.onlineShop.repository;

import com.group08.onlineShop.model.Product;
import com.group08.onlineShop.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StockRepo extends JpaRepository<Stock, Long> {
    List<Stock> findStocksByProduct(Product product);
    List<Stock> findStocksByQuantityGreaterThan(Integer quantity);
    Stock findStockByProductAndColorAndSize(Product product, String color, String size);
}
