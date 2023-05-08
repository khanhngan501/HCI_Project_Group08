package com.group08.onlineShop.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "order_item")
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private Instant createAt;
    private Instant updateAt;
    private String receiverName;
    private String receiverPhoneNumber;
    private String address;
    private Double deliveryChargers;
    private Double totalPrice;
    @OneToOne
    @JoinColumn(name = "status_id")
    private Status status;
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;
}
