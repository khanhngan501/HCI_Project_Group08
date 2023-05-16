package com.group08.onlineShop.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "district")
public class District {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "city_id")
    private Integer cityId;

    @Column(name = "namedistrict")
    private String name;

}