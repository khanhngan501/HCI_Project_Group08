package com.group08.onlineShop.dto.requestDTO;

import lombok.Data;

@Data
public class AddressRequest {
    private String city_id;
    private String city_name;
    private String state_id;
    private String state_name;
    private String country_id;
    private String country_name;
    private String detailAddress;
}