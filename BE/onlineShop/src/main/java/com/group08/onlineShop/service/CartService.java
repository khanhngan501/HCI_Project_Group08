package com.group08.onlineShop.service;

import com.group08.onlineShop.dto.requestDTO.CartRequest;
import com.group08.onlineShop.dto.responseDTO.ApiResponse;
import com.group08.onlineShop.dto.responseDTO.CartResponse;
import com.group08.onlineShop.exception.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;

public interface CartService {
    CartResponse getCartByAccount(Long accountID) throws ResourceNotFoundException;
    CartResponse createCart(CartRequest cartRequest);
    ApiResponse deleteCartByID(Long cartID) throws ResourceNotFoundException;
}
