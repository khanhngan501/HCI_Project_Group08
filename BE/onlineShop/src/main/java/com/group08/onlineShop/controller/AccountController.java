package com.group08.onlineShop.controller;

import com.group08.onlineShop.dto.responseDTO.AccountResponseDTO;
import com.group08.onlineShop.dto.responseDTO.PagedResponse;
import com.group08.onlineShop.exception.ResourceNotFoundException;
import com.group08.onlineShop.model.Account;
import com.group08.onlineShop.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/accounts")
public class AccountController {
    @Autowired
    AccountService accountService;
    @GetMapping("/email/{email}")
    public ResponseEntity<AccountResponseDTO> getAccountByEmail(@PathVariable(name = "email") String email
    ) throws ResourceNotFoundException {
        AccountResponseDTO accountResponseDTO = accountService.getAccountByEmail(email);
        return new ResponseEntity<>(accountResponseDTO, HttpStatus.OK);
    }
}
