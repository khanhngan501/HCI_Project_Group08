package com.group08.onlineShop.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class CategoryDTO {
    private UUID id;
    private String categoryName;

}
