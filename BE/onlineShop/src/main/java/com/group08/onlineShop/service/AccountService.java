package com.group08.onlineShop.service;

import com.group08.onlineShop.model.Account;
import com.group08.onlineShop.model.Role;

public interface AccountService {
    Account signUp(Account account);

    Account saveUser(Account acc);

    void addRoleToUser(String username, String roleName);

    Account getUser(String username);

    Role saveRole(Role role);
}
