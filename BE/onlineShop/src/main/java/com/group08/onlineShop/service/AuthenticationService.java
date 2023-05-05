package com.group08.onlineShop.service;

import com.group08.onlineShop.dto.requestDTO.AuthenticationRequest;
import com.group08.onlineShop.dto.requestDTO.RegisterRequest;
import com.group08.onlineShop.exception.UserNotFoundException;
import org.springframework.http.ResponseEntity;

public interface AuthenticationService {
    ResponseEntity<?> register(RegisterRequest request);
    ResponseEntity<?> authenticate(AuthenticationRequest request) throws UserNotFoundException;

}
