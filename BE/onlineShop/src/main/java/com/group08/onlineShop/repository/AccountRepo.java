package com.group08.onlineShop.repository;

import com.group08.onlineShop.dto.responseDTO.AccountResponseDTO;
import com.group08.onlineShop.model.Account;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.Optional;

@Repository
public interface AccountRepo extends JpaRepository<Account, Long> {
    Optional<Account> findAccountByEmail(String email);
    Page<Account> findAccountByRole(Long role_id, Pageable pageable);
}
