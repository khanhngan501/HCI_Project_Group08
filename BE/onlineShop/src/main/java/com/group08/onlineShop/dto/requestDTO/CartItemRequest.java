package com.group08.onlineShop.dto.requestDTO;

import com.group08.onlineShop.model.Cart;
import com.group08.onlineShop.model.Product;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
public class CartItemRequest {
    private Long product;
    private Integer quantity;
    private Double totalPrice;
    private String size;
    private String color;
    private Long cart;


}
