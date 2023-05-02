package com.group08.onlineShop.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;
    private String receiverName;
    private String receiverPhoneNumber;
    private String address;
    private Double deliveryChargers;
    private Double totalPrice;
    @OneToOne
    @JoinColumn(name = "status_id")
    private Status status;
    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;
}
