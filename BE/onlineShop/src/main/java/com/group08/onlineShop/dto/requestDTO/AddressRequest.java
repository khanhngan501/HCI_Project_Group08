package com.group08.onlineShop.dto.requestDTO;

import lombok.Data;

@Data
public class AddressRequest {
    private Long city;
    private Long district;
    private Long commune;
    private String detailAddress;
}