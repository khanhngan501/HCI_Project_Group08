package com.group08.onlineShop.controller;

import com.group08.onlineShop.dto.requestDTO.CartRequest;
import com.group08.onlineShop.dto.requestDTO.StockRequest;
import com.group08.onlineShop.dto.responseDTO.ApiResponse;
import com.group08.onlineShop.exception.ResourceNotFoundException;
import com.group08.onlineShop.service.CartService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/cart") @Slf4j
@RequiredArgsConstructor
@CrossOrigin(origins ="http://localhost:3000")
public class CartController {
    private final CartService cartService;

    @GetMapping("/get-carts")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<?> getCarts(
            @RequestParam(name="account_id") Long accountID
    ) throws ResourceNotFoundException {
        return ResponseEntity.ok(new ApiResponse(true,
                "Success", HttpStatus.OK.value(),
                cartService.getCartByAccount(accountID)));
    }

    @PostMapping("/create-cart")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<?> createCart(
            @RequestBody CartRequest cartRequest
    ) {
        return ResponseEntity.ok(new ApiResponse(true,
                "Success", HttpStatus.OK.value(),
                cartService.createCart(cartRequest)));
    }

    @DeleteMapping("/delete-cart")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<?> deleteCartByID(
            @RequestParam(name = "cartID") Long cartID
    ) throws ResourceNotFoundException {
        return ResponseEntity.ok(new ApiResponse(true,
                "Success", HttpStatus.OK.value(),
                cartService.deleteCartByID(cartID)));
    }
}
