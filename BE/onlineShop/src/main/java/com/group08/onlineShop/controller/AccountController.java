package com.group08.onlineShop.controller;

import com.group08.onlineShop.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
public class AccountController {
    private AccountService accountService;

}
