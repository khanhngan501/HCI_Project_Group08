package com.group08.onlineShop.repository;

import com.group08.onlineShop.model.Cart;
import com.group08.onlineShop.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartItemRepo extends JpaRepository<CartItem, Long> {
    List<CartItem> findCartItemsByCart(Cart cart);
}
