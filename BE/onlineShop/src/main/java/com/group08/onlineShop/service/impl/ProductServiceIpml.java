package com.group08.onlineShop.service.impl;

import com.group08.onlineShop.dto.ProductReq;
import com.group08.onlineShop.exception.AppException;
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
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class ProductServiceIpml implements ProductService {
    private final CategoryRepo categoryRepo;
    private final ProductRepo productRepo;
    private final ModelMapper modelMapper;

    @Override
    public Product saveNewProduct(ProductReq productReq) {
        Category category =categoryRepo.findById(productReq.getCategory().getId()).orElse(null);
        Product product = modelMapper.map(productReq,Product.class);
        product.setCategory(category);
        productRepo.save(product);
        return product;
    }
    @Override
    public List<Product> findAll() {
        return productRepo.findAllProduct();
    }
    @Override
    public Product findProductById(Long productId) {
        Optional<Product> product = productRepo.findById(productId);
        return product.orElse(null);
    }

    @Override
    public Product updateProduct(ProductReq productReq) {
        Product productUpdate = findProductById(productReq.getId());
        if(productUpdate!=null){
            Product product = new Product();
            Category category = categoryRepo.getReferenceById(productReq.getCategory().getId());
            product.setCategory(category);
            product.setPrice(productReq.getPrice());
            product.setName(productReq.getName());
            return productRepo.save(product);
        }
        else
            throw new AppException(400,"Product does not exists");
    }

    @Override
    public boolean deleteProductById(Long id) {
        Product prductDelete = productRepo.findById(id).orElse(null);
        if(prductDelete !=null){
                productRepo.deleteById(id);
                return true;
        }else{
            throw new AppException(404, "Product ID not found");
        }
    }
}
