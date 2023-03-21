package com.group08.onlineShop.service;

import com.group08.onlineShop.dto.ProductReq;
import com.group08.onlineShop.dto.ProductResp;
import com.group08.onlineShop.model.Category;
import com.group08.onlineShop.model.Product;

import java.util.List;
import java.util.UUID;

public interface ProductService {
    Product saveNewProduct(ProductReq productReq);

    Product findById(Long productId);

    List<Product> findAll() ;
    Product updateProduct(ProductReq productReq);

    boolean deleteProductById(Long id);

}
