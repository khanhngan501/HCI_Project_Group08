package com.group08.onlineShop.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "commune")
public class Commune {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "district_id")
    private Integer districtId;

    @Column(name = "name")
    private String name;
}
