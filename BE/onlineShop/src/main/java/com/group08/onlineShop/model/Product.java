package com.group08.onlineShop.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private UUID id;
    private String name;
    private Double price;
    @ManyToOne(fetch = FetchType.LAZY)
    private Category category;
}
