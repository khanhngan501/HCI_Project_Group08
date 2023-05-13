package com.group08.onlineShop.model;

import jakarta.persistence.*;
import lombok.*;

import java.awt.print.PrinterGraphics;
import java.util.function.DoubleToLongFunction;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cart_item")
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
    private Integer quantity;
    private Double totalPrice;
    private String size;
    private String color;
    @ManyToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;

    public CartItem(Product product, Integer quantity, Double totalPrice, String size, String color, Cart cart) {
        this.product = product;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.size = size;
        this.color = color;
        this.cart = cart;
    }
}
