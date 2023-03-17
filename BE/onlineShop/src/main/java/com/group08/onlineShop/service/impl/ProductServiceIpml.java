package com.group08.onlineShop.service.impl;

import com.group08.onlineShop.dto.ProductReq;
import com.group08.onlineShop.dto.ProductResp;
import com.group08.onlineShop.model.Category;
import com.group08.onlineShop.model.Product;
import com.group08.onlineShop.repository.CategoryRepo;
import com.group08.onlineShop.repository.ProductRepo;
import com.group08.onlineShop.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class ProductServiceIpml implements ProductService {
    private final CategoryRepo categoryRepo;
    private final ProductRepo productRepo;

    private final ModelMapper modelMapper;

    @Override
    public Product saveNewProduct(ProductReq productReq) {
        Category category = categoryRepo.getReferenceById(productReq.getCategory().getId());
        Product product = modelMapper.map(productReq, Product.class);
        product.setCategory(category);
        productRepo.save(product);
        return product;
    }

    @Override
    public ProductResp findProductById(Long productId) {
        return null;
    }

    @Override
    public Product updateProduct(ProductReq productReq) {
        return null;
    }

    @Override
    public void deleteProductById(Long id) {

    }
}
