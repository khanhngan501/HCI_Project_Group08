package com.group08.onlineShop.controller;

import com.group08.onlineShop.service.ProductService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
public class ProductController {
    private ProductService productService;
}
