package com.group08.onlineShop.service.impl;

import com.group08.onlineShop.dto.requestDTO.AccountRequestDTO;
import com.group08.onlineShop.dto.responseDTO.AccountResponseDTO;
import com.group08.onlineShop.dto.responseDTO.ApiResponse;
import com.group08.onlineShop.dto.responseDTO.PagedResponse;
import com.group08.onlineShop.exception.ResourceNotFoundException;
import com.group08.onlineShop.model.Account;
import com.group08.onlineShop.model.Role;
import com.group08.onlineShop.repository.AccountRepo;
import com.group08.onlineShop.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountRepo accountRepo;

    @Override
    public AccountResponseDTO createAccount(AccountRequestDTO account) {
        return null;
    }

    @Override
    public AccountResponseDTO getAccountByEmail(String email) throws ResourceNotFoundException {
        Optional<Account> account = accountRepo.findAccountByEmail(email);
        if (!account.isPresent()) {
            throw new ResourceNotFoundException("Account", "email", email);
        }
        Account accountResult = account.get();
        Role roleAccount = accountResult.getRole();
        Long roleID = roleAccount.getId();

        return new AccountResponseDTO(accountResult.getId(), accountResult.getEmail(), accountResult.getFirstName(),
                accountResult.getLastName(), roleID, accountResult.getActive());
    }

    @Override
    public PagedResponse<Account> getAccountByRole(long role_id, int page, int size) throws ResourceNotFoundException {
        Pageable pageable = PageRequest.of(page, size, Sort.Direction.DESC, "email");
        Page<Account> accounts = accountRepo.findAccountByRole(role_id, pageable);
        List<Account> content = accounts.getNumberOfElements() == 0 ? Collections.emptyList() : accounts.getContent();
        return new PagedResponse<>(content, accounts.getNumber(), accounts.getSize(), accounts.getTotalElements(),
                accounts.getTotalPages(), accounts.isLast());
    }

    @Override
    public ApiResponse unableAccount(String accountID) throws ResourceNotFoundException {
        return null;
    }
}
