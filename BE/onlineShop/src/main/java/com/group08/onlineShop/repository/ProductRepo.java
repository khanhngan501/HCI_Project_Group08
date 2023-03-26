package com.group08.onlineShop.repository;

import com.group08.onlineShop.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product, Long> {
}
