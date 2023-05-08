package com.group08.onlineShop.service;

import com.group08.onlineShop.dto.responseDTO.CartItemResponse;

import java.util.List;

public interface CartItemService {
    List<CartItemResponse> getAllCart();
    List<CartItemResponse> getCartItemsByCartID(Long cartID);
}
