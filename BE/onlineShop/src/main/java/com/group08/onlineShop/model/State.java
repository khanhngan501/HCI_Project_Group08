package com.group08.onlineShop.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "state")
public class State {
    @Id
    @Column(name = "id")
    private Integer id;
    @Column(name = "state_name")
    private String stateName;
}