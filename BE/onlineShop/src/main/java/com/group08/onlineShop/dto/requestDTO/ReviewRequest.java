package com.group08.onlineShop.dto.requestDTO;

import lombok.Data;

import java.time.Instant;

@Data
public class ReviewRequest {
    private Long account;
    private Long product;
    private Instant createAt;
    private String content;
    private Float rate;
    private Integer like;
    private Integer dislike;
}
