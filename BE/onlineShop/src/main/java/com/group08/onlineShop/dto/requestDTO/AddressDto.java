package com.group08.onlineShop.dto.requestDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class AddressDto {

    private Integer cityId;

    private Integer districtId;

    private Integer communeId;

    private String details;

}
