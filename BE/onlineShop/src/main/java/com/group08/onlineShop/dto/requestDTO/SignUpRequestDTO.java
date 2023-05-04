package com.group08.onlineShop.dto.requestDTO;

import com.group08.onlineShop.model.Role;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
public class SignUpRequestDTO {
    private String email;
    @Column(length = 20)
    private String firstName;
    @Column(length = 20)
    private String lastName;
    private String password;
}
