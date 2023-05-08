package com.group08.onlineShop.service.impl;

import com.group08.onlineShop.dto.responseDTO.ApiResponse;
import com.group08.onlineShop.dto.responseDTO.CartItemResponse;
import com.group08.onlineShop.exception.BadRequestException;
import com.group08.onlineShop.model.Cart;
import com.group08.onlineShop.model.CartItem;
import com.group08.onlineShop.repository.CartItemRepo;
import com.group08.onlineShop.repository.CartRepo;
import com.group08.onlineShop.service.CartItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CartItemServiceImpl implements CartItemService {
    private final CartItemRepo cartItemRepo;
    private final CartRepo cartRepo;
    @Override
    public List<CartItemResponse> getAllCart() {
        List<CartItem> cartItems = cartItemRepo.findAll();
        return addCartItemsResponse(cartItems);
    }

    @Override
    public List<CartItemResponse> getCartItemsByCartID(Long cartID) {
        Optional<Cart> cart =cartRepo.findById(cartID);
        if (cart.isPresent()) {
            List<CartItem> cartItems = cartItemRepo.findCartItemsByCart(cart.get());
            return addCartItemsResponse(cartItems);
        }
        ApiResponse apiResponse = new ApiResponse(Boolean.FALSE, "Can not find cart item by cartID = " + cartID, HttpStatus.NOT_FOUND.value());
        throw new BadRequestException(apiResponse);
    }

    private List<CartItemResponse> addCartItemsResponse(List<CartItem> cartItems){
        List<CartItemResponse> cartItemResponses = new ArrayList<>(cartItems.size());
        for(CartItem cartItem : cartItems) {
            cartItemResponses.add(new CartItemResponse(cartItem.getId(), cartItem.getProduct().getId(),
                    cartItem.getQuantity(), cartItem.getTotalPrice(), cartItem.getSize(),
                    cartItem.getColor(), cartItem.getCart().getId()));
        }
        return cartItemResponses;
    }
}
