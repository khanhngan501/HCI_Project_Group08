package com.group08.onlineShop.service;

import com.group08.onlineShop.dto.requestDTO.ProductReq;
import com.group08.onlineShop.exception.ResourceNotFoundException;
import com.group08.onlineShop.model.Product;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductService {
    Product saveNewProduct(ProductReq productReq);

    Product findById(Long productId) throws ResourceNotFoundException;
    List<Product> suggestProduct(ProductReq productReq) throws ResourceNotFoundException;

    List<Product> filterProduct(String keyword) throws ResourceNotFoundException;
    List<Product> findAll();

    Product updateProduct(ProductReq productReq) throws ResourceNotFoundException;

    boolean deleteProductById(Long id);

}
