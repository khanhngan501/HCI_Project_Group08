package com.group08.onlineShop.service;

import com.group08.onlineShop.dto.requestDTO.AccountRequestDTO;
import com.group08.onlineShop.dto.responseDTO.AccountResponseDTO;
import com.group08.onlineShop.dto.responseDTO.ApiResponse;
import com.group08.onlineShop.dto.responseDTO.PagedResponse;
import com.group08.onlineShop.exception.ResourceNotFoundException;
import com.group08.onlineShop.model.Account;

import java.util.List;

public interface AccountService {
    AccountResponseDTO createAccount(AccountRequestDTO account);

    AccountResponseDTO getAccountByEmail(String email) throws ResourceNotFoundException;

    PagedResponse<Account> getAccountByRole(long role_id, int page, int size) throws ResourceNotFoundException;

    ApiResponse unableAccount(String accountID) throws ResourceNotFoundException;
}
