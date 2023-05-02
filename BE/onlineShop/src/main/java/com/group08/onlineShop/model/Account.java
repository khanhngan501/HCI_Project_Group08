package com.group08.onlineShop.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String firstName;
    private String lastName;
    @OneToOne
    @JoinColumn(name = "role_id")
    private Role role;
    private String password;
    private Boolean active;
}
