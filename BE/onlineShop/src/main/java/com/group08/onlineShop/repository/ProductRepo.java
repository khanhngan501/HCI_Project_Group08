package com.group08.onlineShop.repository;

import com.group08.onlineShop.model.Category;
import com.group08.onlineShop.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {
    @Query("select p from Product p")
    List<Product> findAllProduct();
}
