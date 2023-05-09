package com.group08.onlineShop.controller;

import com.group08.onlineShop.dto.ProductReq;
import com.group08.onlineShop.dto.ResponseDTO;
import com.group08.onlineShop.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping("/post-product")
    public ResponseEntity<?> postProduct(@RequestBody ProductReq productReq) {
        try {
            return ResponseEntity.ok(new ResponseDTO(true, "Success", productService.saveNewProduct(productReq)));
        } catch (Exception e) {
            return ResponseEntity.ok(new ResponseDTO(false, e.getMessage(), null));
        }
    }

    @GetMapping("/all-product")
    public ResponseEntity<?> getAllProduct() {
        try {
            return ResponseEntity.ok(new ResponseDTO(true, "Success", productService.findAll()));
        } catch (Exception e) {
            return ResponseEntity.ok(new ResponseDTO(false, e.getMessage(), null));
        }
    }
    @GetMapping("/sugest-product")
    public ResponseEntity<?> sugestProduct(@RequestBody ProductReq productReq) {
        try {
            return ResponseEntity.ok(new ResponseDTO(true, "Success", productService.suggestProduct(productReq)));
        } catch (Exception e) {
            return ResponseEntity.ok(new ResponseDTO(false, e.getMessage(), null));
        }
    }
    @GetMapping("/product/{proId}")
    public ResponseEntity<?> getProductById(@PathVariable(value = "proId") Long proId) {
        try {
            return ResponseEntity.ok(new ResponseDTO(true, "Success", productService.findById(proId)));
        } catch (Exception e) {
            return ResponseEntity.ok(new ResponseDTO(false, e.getMessage(), null));
        }
    }

    @PutMapping("/update-product")
    public ResponseEntity<?> updateProduct(@RequestBody ProductReq productReq) {
        try {
            return ResponseEntity.ok(new ResponseDTO(true, "Success", productService.updateProduct(productReq)));
        } catch (Exception e) {
            return ResponseEntity.ok(new ResponseDTO(false, e.getMessage(), null));
        }
    }

    @DeleteMapping("/delete-product")
    public ResponseEntity<?> deleteProduct(@RequestParam Long productId) {
        try {
            return ResponseEntity.ok(new ResponseDTO(true, "Success", productService.deleteProductById(productId)));
        } catch (Exception e) {
            return ResponseEntity.ok(new ResponseDTO(false, e.getMessage(), null));
        }
    }
}
