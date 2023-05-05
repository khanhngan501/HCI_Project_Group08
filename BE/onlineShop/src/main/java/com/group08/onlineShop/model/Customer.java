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
    @Column(name = "phone_number", length = 12)
    private String phoneNumber;
    @Column(name = "default_address", length = 50)
    private String defaultAddress;
    @Column(name = "customer_name", length = 45)
    private String customerName;
}