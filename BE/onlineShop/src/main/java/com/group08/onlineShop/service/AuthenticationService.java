package com.group08.onlineShop.service;

import com.group08.onlineShop.dto.requestDTO.AuthenticationRequest;
import com.group08.onlineShop.dto.requestDTO.PasswordDto;
import com.group08.onlineShop.dto.requestDTO.RegisterRequest;
import com.group08.onlineShop.exception.UserNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;

public interface AuthenticationService {
    ResponseEntity<?> register(RegisterRequest request);
    ResponseEntity<?> authenticate(AuthenticationRequest request) throws UserNotFoundException;

    void forgotPasswordForAccount(String username, HttpServletRequest request) throws UserNotFoundException;

    String validatePasswordResetToken(String token);

    void changeAccountPassword(PasswordDto passwordDto);
}
