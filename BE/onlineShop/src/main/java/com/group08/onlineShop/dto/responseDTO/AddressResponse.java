package com.group08.onlineShop.dto.responseDTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddressResponse {
    private Long id;
    private String city_id;
    private String city_name;
    private String state_id;
    private String state_name;
    private String country_id;
    private String country_name;
    private String detailAddress;
}
