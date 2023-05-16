package com.group08.onlineShop.dto.responseDTO;

import com.group08.onlineShop.model.Account;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CartItemResponse {
    private Long id;
    private Long product;
    private Integer quantity;
    private Double totalPrice;
    private String size;
    private String color;
    private Account account;
}
