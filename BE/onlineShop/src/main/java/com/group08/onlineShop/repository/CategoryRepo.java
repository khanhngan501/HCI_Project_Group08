package com.group08.onlineShop.repository;

import com.group08.onlineShop.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CategoryRepo extends JpaRepository<Category, UUID> {
}
