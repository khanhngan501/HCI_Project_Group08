package com.group08.onlineShop.controller;

import com.group08.onlineShop.dto.CategoryDTO;
import com.group08.onlineShop.dto.responseDTO.ApiResponse;
import com.group08.onlineShop.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @PostMapping("/post-category")
    public ResponseEntity<?> postCategory(@RequestBody CategoryDTO categoryDTO) {
        try {
            return ResponseEntity.ok(new ApiResponse(true, "Success", HttpStatus.OK, categoryService.save(categoryDTO)));
        } catch (Exception e) {
            return ResponseEntity.ok(new ApiResponse(false, e.getMessage(), HttpStatus.BAD_REQUEST));
        }
    }

    @GetMapping("/all-category")
    public ResponseEntity<?> getAllCategory() {
        try {
            return ResponseEntity.ok(new ApiResponse(true, "Success", HttpStatus.OK, categoryService.findAll()));
        } catch (Exception e) {
            return ResponseEntity.ok(new ApiResponse(false, e.getMessage(), HttpStatus.NOT_FOUND));
        }
    }

    @PutMapping("/update-category")
    public ResponseEntity<?> updateCategory(@RequestBody CategoryDTO categoryDTO) {
        try {
            return ResponseEntity.ok(new ApiResponse(true, "Success", HttpStatus.OK, categoryService.updateCategory(categoryDTO)));
        } catch (Exception e) {
            return ResponseEntity.ok(new ApiResponse(false, e.getMessage(), HttpStatus.BAD_REQUEST));
        }
    }

    @DeleteMapping("/delete-category")
    public ResponseEntity<?> deleteCategory(@RequestParam Long categoryId) {
        try {
            return ResponseEntity.ok(new ApiResponse(true, "Success", HttpStatus.OK, categoryService.deleteCategory(categoryId)));
        } catch (Exception e) {
            return ResponseEntity.ok(new ApiResponse(false, e.getMessage(), HttpStatus.BAD_REQUEST));
        }
    }
}
