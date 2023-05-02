package com.group08.onlineShop.service.impl;

import com.group08.onlineShop.dto.requestDTO.ProductReq;
import com.group08.onlineShop.exception.AppException;
import com.group08.onlineShop.exception.ResourceNotFoundException;
import com.group08.onlineShop.model.Category;
import com.group08.onlineShop.model.Product;
import com.group08.onlineShop.repository.CategoryRepo;
import com.group08.onlineShop.repository.ProductRepo;
import com.group08.onlineShop.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ProductServiceIpml implements ProductService {
    private final CategoryRepo categoryRepo;
    private final ProductRepo productRepo;
    private final ModelMapper modelMapper;

    @Override
    public Product saveNewProduct(ProductReq productReq) {
        Category category = categoryRepo.findById(productReq.getCategory().getId()).orElse(null);
        Product product = modelMapper.map(productReq, Product.class);
        product.setCategory(category);
        productRepo.save(product);
        return product;
    }

    @Override
    public List<Product> findAll() {
        return productRepo.findAll();
    }

    @Override
    public Product findById(Long productId) throws ResourceNotFoundException {
        var product = productRepo.findById(productId).
                orElseThrow(() -> new ResourceNotFoundException("Product", "productID", Long.toString(productId)));
        return product;
    }

    @Override
    public Product updateProduct(Long proId, ProductReq productReq) throws ResourceNotFoundException {
        Product productUpdate = findById(proId);
        productUpdate.setCategory(productReq.getCategory());
        productUpdate.setPrice(productReq.getPrice());
        productUpdate.setProductName(productReq.getProductName());
        return productUpdate;
    }

    @Override
    public boolean deleteProductById(Long id) {
        Product productDelete = productRepo.findById(id).orElse(null);
        if (productDelete != null) {
            productRepo.deleteById(id);
            return true;
        } else {
            throw new AppException(404, "Product ID not found");
        }
    }
}
