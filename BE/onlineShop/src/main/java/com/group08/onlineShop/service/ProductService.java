package com.group08.onlineShop.service;

import com.group08.onlineShop.dto.ProductReq;
import com.group08.onlineShop.dto.ProductResp;
import com.group08.onlineShop.model.Product;

public interface ProductService {
    Product saveNewProduct(ProductReq productReq);

    ProductResp findProductById(Long productId);

    Product updateProduct(ProductReq productReq);

    void deleteProductById(Long id);

}
