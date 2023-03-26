package com.group08.onlineShop.repository;

import com.group08.onlineShop.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepo extends JpaRepository<Account, Long> {
}
