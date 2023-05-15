package com.group08.onlineShop.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data @Table @Entity
public class City {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "cityname")
    private String name;

}
