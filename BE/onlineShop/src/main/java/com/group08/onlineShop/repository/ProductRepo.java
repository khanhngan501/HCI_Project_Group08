package com.group08.onlineShop.repository;

import com.group08.onlineShop.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepo extends JpaRepository<Product, Long> {
    @Query("SELECT p FROM Product p WHERE CONCAT(p.category, p.type,  p.price) LIKE %?1%")
    public List<Product> search(String keyword);
}
