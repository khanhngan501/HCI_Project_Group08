package com.group08.onlineShop.service.impl;

import com.group08.onlineShop.dto.requestDTO.AuthenticationRequest;
import com.group08.onlineShop.dto.requestDTO.RegisterRequest;
import com.group08.onlineShop.dto.responseDTO.AuthenticationResponse;
import com.group08.onlineShop.exception.UserNotFoundException;
import com.group08.onlineShop.model.Account;
import com.group08.onlineShop.model.Role;
import com.group08.onlineShop.repository.AccountRepo;
import com.group08.onlineShop.service.AuthenticationService;
import com.group08.onlineShop.service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final AccountRepo accountRepo;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    public ResponseEntity<?> register(RegisterRequest request) {
        // add check for email exists in DB
        if(accountRepo.existsByEmail(request.getEmail())){
            return new ResponseEntity<>("Email is already taken!", HttpStatus.BAD_REQUEST);
        }
        var user = Account.builder().firstName(request.getFirstName()).
                lastName(request.getLastName()).email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .active(true)
                .build();
        accountRepo.save(user);
        var jwtToken = jwtService.generateToken(user);
        return new ResponseEntity<>(AuthenticationResponse.builder()
                .token(jwtToken)
                .build(), HttpStatus.OK);
    }

    public ResponseEntity<?> authenticate(AuthenticationRequest request) throws UserNotFoundException{
        var user = accountRepo.findAccountByEmail(request.getEmail()).
                orElseThrow(() -> new UserNotFoundException(request.getEmail()));

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
        );
        var jwtToken = jwtService.generateToken(user);
        return new ResponseEntity<>(AuthenticationResponse.builder()
                .token(jwtToken)
                .build(), HttpStatus.OK);
    }
}
