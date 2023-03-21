package com.group08.onlineShop.dto;

import com.group08.onlineShop.model.Category;
import lombok.Data;


@Data
public class ProductReq {
    private Long id;
    private String name;
    private Double price;
    private Category category;
}
