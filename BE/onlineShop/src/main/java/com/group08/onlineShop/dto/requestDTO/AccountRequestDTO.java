package com.group08.onlineShop.dto.requestDTO;

//import com.group08.onlineShop.model.Role;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
public class AccountRequestDTO {
    private String email;
    private String firstName;
    private String lastName;
    private Long role_id;
    private String password;
    private Boolean active;
}
