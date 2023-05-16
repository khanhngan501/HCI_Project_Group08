package com.group08.onlineShop.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;
    @ManyToOne
    @JoinColumn(name = "district_id")
    private District district;
    @ManyToOne
    @JoinColumn(name = "commune_id")
    private Commune commune;
    private String detailAddress;
}
