package com.group08.onlineShop.controller;

import com.group08.onlineShop.model.Account;
import com.group08.onlineShop.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class SignUpController {
    @Autowired
    private AccountService accountService;

    @PostMapping("/account")
    public String signUp(@RequestBody Account account) {
        accountService.signUp(account);
        return "Sign up successfully";
    }
}
