package com.group08.onlineShop.service;

import com.group08.onlineShop.dto.CategoryDTO;
import com.group08.onlineShop.model.Category;

import java.util.List;
import java.util.UUID;

public interface CategoryService {
    Category findById(Long id);
    List<Category> findAll();
    Category save(CategoryDTO categoryDTO);
    Category updateCategory(CategoryDTO categoryDTO);
    Boolean deleteCategory(Long categoryId);

}
