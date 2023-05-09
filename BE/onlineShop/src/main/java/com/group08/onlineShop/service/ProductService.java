package com.group08.onlineShop.service;

import com.group08.onlineShop.dto.ProductReq;
import com.group08.onlineShop.model.Product;

import java.util.List;

public interface ProductService {
    Product saveNewProduct(ProductReq productReq);

    Product findById(Long productId);

    List<Product> findAll();
    List<Product> suggestProduct(ProductReq productReq);
    Product updateProduct(ProductReq productReq);

    boolean deleteProductById(Long id);

}
