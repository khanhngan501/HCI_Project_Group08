package com.group08.onlineShop.dto.requestDTO;

import com.group08.onlineShop.model.Role;
import lombok.Data;

@Data
public class AccountRequestDTO {
    private Long id;
    private String email;
    private String firstName;
    private String lastName;
    private Role role;
    private Boolean active;
}
