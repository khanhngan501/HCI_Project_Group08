package com.group08.onlineShop.model;

import jakarta.persistence.*;
import lombok.*;
import org.modelmapper.spi.StrongTypeConditionalConverter;

@Data
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "product_image")
public class ProductImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
    private String imageLink;
    private Boolean isDefault;
    private String color;
}
