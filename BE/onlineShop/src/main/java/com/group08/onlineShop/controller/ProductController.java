package com.group08.onlineShop.controller;

import com.group08.onlineShop.dto.requestDTO.ProductReq;
import com.group08.onlineShop.dto.responseDTO.ApiResponse;
import com.group08.onlineShop.dto.responseDTO.ProductResp;
import com.group08.onlineShop.exception.ResourceNotFoundException;
import com.group08.onlineShop.model.Product;
import com.group08.onlineShop.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
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
            return ResponseEntity.ok(new ApiResponse(true, "Success", HttpStatus.CREATED.value(), productService.saveNewProduct(productReq)));
        } catch (Exception e) {
            return ResponseEntity.ok(new ApiResponse(false, e.getMessage(), HttpStatus.BAD_REQUEST.value()));
        }
    }

    @GetMapping("/all-product")
    public ResponseEntity<?> getAllProduct() {
        try {
            return ResponseEntity.ok(new ApiResponse(true, "Success", HttpStatus.OK.value(), productService.findAll()));
        } catch (Exception e) {
            return ResponseEntity.ok(new ApiResponse(false, e.getMessage(), HttpStatus.BAD_REQUEST.value()));
        }
    }

    @GetMapping("/product/{proId}")
    public ResponseEntity<?> getProductById(@PathVariable(value = "proId") Long proId) {
        try {
            return ResponseEntity.ok(new ApiResponse(true, "Success", HttpStatus.OK.value(), productService.findById(proId)));
        } catch (Exception e) {
            return ResponseEntity.ok(new ApiResponse(false, e.getMessage(), HttpStatus.BAD_REQUEST.value()));
        }
    }

    @PutMapping("/update-product/{proId}")
    public ResponseEntity<?> updateProduct(@PathVariable(value = "proId")  Long proId, @RequestBody ProductReq productReq) throws ResourceNotFoundException {
        Product productResp = productService.updateProduct(proId, productReq);
        return new ResponseEntity<>(productResp, HttpStatus.OK);
    }

    @DeleteMapping("/delete-product")
    public ResponseEntity<?> deleteProduct(@RequestParam Long productId) {
        try {
            return ResponseEntity.ok(new ApiResponse(true, "Success", HttpStatus.OK.value(), productService.deleteProductById(productId)));
        } catch (Exception e) {
            return ResponseEntity.ok(new ApiResponse(false, e.getMessage(), HttpStatus.BAD_REQUEST.value()));
        }
    }
}
