package com.group08.onlineShop.dto.responseDTO;

import lombok.Data;

@Data
public class CartResponse {
    private Long id;
    private Long account_id;

    public CartResponse(Long id, Long account_id) {
        this.id = id;
        this.account_id = account_id;
    }
}
