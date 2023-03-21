package com.group08.onlineShop.controller;

import com.group08.onlineShop.dto.CategoryDTO;
import com.group08.onlineShop.dto.ResponseDTO;
import com.group08.onlineShop.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;
    @PostMapping("/post-category")
    public ResponseEntity<?> postCategory(@RequestBody CategoryDTO categoryDTO)
    {
        try {
            return ResponseEntity.ok(new ResponseDTO(true, "Success", categoryService.save(categoryDTO)));
        } catch (Exception e) {
            return ResponseEntity.ok(new ResponseDTO(false, e.getMessage(), null));
        }
    }
}
