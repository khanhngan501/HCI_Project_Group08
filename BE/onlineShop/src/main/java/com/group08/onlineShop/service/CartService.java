package com.group08.onlineShop.service;

import com.group08.onlineShop.dto.responseDTO.ApiResponse;
import com.group08.onlineShop.dto.responseDTO.CartResponse;
import org.springframework.http.ResponseEntity;

public interface CartService {
    CartResponse createCart(Long accountID);

}
