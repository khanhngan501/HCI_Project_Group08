package com.group08.onlineShop.dto.responseDTO;

import com.group08.onlineShop.model.Cart;
import com.group08.onlineShop.model.Product;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
public class CartItemResponse {
    private Long id;
    private Long product;
    private Integer quantity;
    private Double totalPrice;
    private String size;
    private String color;
    private Long cart;

    public CartItemResponse(Long id, Long product, Integer quantity, Double totalPrice, String size, String color, Long cart) {
        this.id = id;
        this.product = product;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.size = size;
        this.color = color;
        this.cart = cart;
    }
}
