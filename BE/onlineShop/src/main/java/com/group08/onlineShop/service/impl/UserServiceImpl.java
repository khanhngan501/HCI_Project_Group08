package com.group08.onlineShop.service.impl;

import com.group08.onlineShop.model.User;
import com.group08.onlineShop.repository.UserRepo;
import com.group08.onlineShop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;
    @Override
    public User signUp(User user) {
        return userRepo.save(user);
    }
}
