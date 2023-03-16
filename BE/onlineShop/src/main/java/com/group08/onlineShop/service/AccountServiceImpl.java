package com.group08.onlineShop.service;

import com.group08.onlineShop.model.Account;
import com.group08.onlineShop.model.Role;
import com.group08.onlineShop.repository.AccountRepo;
import com.group08.onlineShop.repository.RoleRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepo accountRepo;

    private final PasswordEncoder passwordEncoder;

    private final RoleRepo roleRepo;

    @Override
    public Account signUp(Account account) {
        return accountRepo.save(account);
    }

    @Override
    public Account saveUser(Account acc) {

//        log.info("Saving new customer {} to the database", cus.getUsername());
        String plainPassword = acc.getPassword();
        acc.setPassword(passwordEncoder.encode(plainPassword));

        return accountRepo.saveAndFlush(acc);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        Account userApp = accountRepo.findByUsername(username)
                .orElseThrow(() ->
                        new UsernameNotFoundException("User Not Found with -> username or email :"
                                + username));

        Role role = roleRepo.findByName(roleName);

        userApp.getRoles().add(role);
    }

    @Override
    public Account getUser(String username) {
        return null;
    }

    @Override
    public Role saveRole(Role role) {
        return roleRepo.saveAndFlush(role);
    }
}
