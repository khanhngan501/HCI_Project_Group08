package com.group08.onlineShop.service;

import com.group08.onlineShop.dto.requestDTO.ProductReq;
import com.group08.onlineShop.exception.ResourceNotFoundException;
import com.group08.onlineShop.model.Product;

import java.util.List;

public interface ProductService {
    Product saveNewProduct(ProductReq productReq);

    Product findById(Long productId) throws ResourceNotFoundException;

    List<Product> findAll();

    Product updateProduct(Long proId, ProductReq productReq) throws ResourceNotFoundException;

    boolean deleteProductById(Long id);

}
