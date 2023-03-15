package com.group08.onlineShop.service;

import com.group08.onlineShop.model.Account;
import com.group08.onlineShop.repository.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountRepo accountRepo;
    @Override
    public Account signUp(Account account) {
        return accountRepo.save(account);
    }
}
