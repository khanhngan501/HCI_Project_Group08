package com.group08.onlineShop.service;

import com.group08.onlineShop.dto.requestDTO.CartItemRequest;
import com.group08.onlineShop.dto.responseDTO.ApiResponse;
import com.group08.onlineShop.dto.responseDTO.CartItemResponse;
import com.group08.onlineShop.exception.ResourceNotFoundException;

import java.util.List;

public interface CartItemService {
    List<CartItemResponse> getAllCartItems();
    List<CartItemResponse> getCartItemsByAccount(Long cartID) throws ResourceNotFoundException;
    CartItemResponse getCartItemByID(Long cartItemID) throws ResourceNotFoundException;
    CartItemResponse addCartItem(CartItemRequest cartItemRequest) throws ResourceNotFoundException;
    CartItemResponse updateCartItem(Long cartItemID, CartItemRequest cartItemRequest) throws ResourceNotFoundException;
    ApiResponse deleteCartItemByCartItemID(Long cartItemID) throws ResourceNotFoundException;

}
