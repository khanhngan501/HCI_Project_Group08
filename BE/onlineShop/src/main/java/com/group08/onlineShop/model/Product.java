package com.group08.onlineShop.model;

import com.group08.onlineShop.dto.TypeProduct;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double price;
    @ManyToOne(fetch = FetchType.EAGER)
    private Category category;
    private TypeProduct type;
}
