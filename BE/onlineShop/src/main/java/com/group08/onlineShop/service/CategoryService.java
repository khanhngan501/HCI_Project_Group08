package com.group08.onlineShop.service;

import com.group08.onlineShop.dto.CategoryDTO;
import com.group08.onlineShop.model.Category;

import java.util.List;
import java.util.UUID;

public interface CategoryService {
    Category findById(UUID id);
    List<Category> findAll();
    Category save(CategoryDTO categoryDTO);
    Category updateCategory(CategoryDTO categoryDTO);
    Boolean deleteCategory(UUID categoryId);

}
