package com.group08.onlineShop.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.time.LocalDateTime;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "review")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
    private Instant createAt;
    private String content;
    private Float rate;
    private Integer like;
    private Integer dislike;

    public Review(Account account, Product product, Instant createAt, String content, Float rate, Integer like, Integer dislike) {
        this.account = account;
        this.product = product;
        this.createAt = createAt;
        this.content = content;
        this.rate = rate;
        this.like = like;
        this.dislike = dislike;
    }
}
