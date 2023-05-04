package com.group08.onlineShop.service.impl;
import com.group08.onlineShop.model.Account;
import com.group08.onlineShop.repository.AccountRepo;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CustomUserDetailsService implements UserDetailsService{
    private AccountRepo accountRepo;

    public CustomUserDetailsService(AccountRepo accountRepo) {
        this.accountRepo = accountRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Account account = accountRepo.findAccountByEmail(email)
                .orElseThrow(() ->
                        new UsernameNotFoundException("User not found with email: "+ email));

        Set<GrantedAuthority> authorities = account
                .getRoles()
                .stream()
                .map((role) -> new SimpleGrantedAuthority(role.getRoleName())).collect(Collectors.toSet());

        return new org.springframework.security.core.userdetails.User(account.getEmail(),
                account.getPassword(),
                authorities);
    }
}
