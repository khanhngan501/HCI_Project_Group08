package com.group08.onlineShop.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @OneToOne
    @JoinColumn(name = "account_id")
    private Account account;
    @Column(name = "phoneNumber")
    private String phoneNumber;
    @Column(name = "defaultAddress")
    private String defaultAddress;
    @Column(name = "customerName")
    private String customerName;
}
