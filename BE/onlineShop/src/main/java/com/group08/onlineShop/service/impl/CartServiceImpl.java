package com.group08.onlineShop.service.impl;

import com.group08.onlineShop.dto.requestDTO.CartRequest;
import com.group08.onlineShop.dto.responseDTO.ApiResponse;
import com.group08.onlineShop.dto.responseDTO.CartResponse;
import com.group08.onlineShop.exception.BadRequestException;
import com.group08.onlineShop.exception.ResourceNotFoundException;
import com.group08.onlineShop.exception.UserNotFoundException;
import com.group08.onlineShop.model.Account;
import com.group08.onlineShop.model.Cart;
import com.group08.onlineShop.repository.AccountRepo;
import com.group08.onlineShop.repository.CartRepo;
import com.group08.onlineShop.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {
    private final CartRepo cartRepo;
    private final AccountRepo accountRepo;

    @Override
    public CartResponse getCartByAccount(Long accountID) throws ResourceNotFoundException {
        Account account = accountRepo.findById(accountID).
                orElseThrow(() -> new ResourceNotFoundException("Account", "accountID", accountID));
        Cart cart = cartRepo.findCartByAccount(account).
                orElseThrow(() -> new ResourceNotFoundException("Cart", "accountID", accountID));
        return new CartResponse(cart.getAccount().getId(), cart.getId());
    }

    @Override
    public CartResponse createCart(CartRequest cartRequest) {
        Optional<Account> account = accountRepo.findById(cartRequest.getAccount_id());
        if (account != null) {
            Cart cart = new Cart(account.get());
            Cart newCart = cartRepo.save(cart);
            return new CartResponse(newCart.getId(), newCart.getAccount().getId());
        }
        ApiResponse apiResponse = new ApiResponse(Boolean.FALSE, "Can not create cart for this user", HttpStatus.BAD_REQUEST.value());
        throw new BadRequestException(apiResponse);
    }

    @Override
    public ApiResponse deleteCartByID(Long cartID) throws ResourceNotFoundException {
        Cart cart = cartRepo.findById(cartID).orElseThrow(() ->
                new ResourceNotFoundException("Cart", "cartID", cartID));
        cartRepo.deleteById(cartID);
        return new ApiResponse(Boolean.TRUE, "Cart deleted successfully");
    }
}
