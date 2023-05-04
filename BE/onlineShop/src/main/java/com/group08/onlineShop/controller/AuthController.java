package com.group08.onlineShop.controller;

import com.group08.onlineShop.dto.requestDTO.LoginRequestDTO;
import com.group08.onlineShop.dto.requestDTO.SignUpRequestDTO;
import com.group08.onlineShop.dto.responseDTO.ApiResponse;
import com.group08.onlineShop.model.Account;
import com.group08.onlineShop.model.Role;
import com.group08.onlineShop.repository.AccountRepo;
import com.group08.onlineShop.repository.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private AccountRepo accountRepo;

    @Autowired
    private RoleRepo roleRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginRequestDTO loginDto){
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginDto.getEmail(), loginDto.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        return ResponseEntity.ok(new ApiResponse(true, "User signed-in successfully!", HttpStatus.OK));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody SignUpRequestDTO signUpDto){
        // add check for email exists in DB
        if(accountRepo.existsByEmail(signUpDto.getEmail())){
            return new ResponseEntity<>("Email is already taken!", HttpStatus.BAD_REQUEST);
        }

        // create user object
        Account account = new Account();
        account.setEmail(signUpDto.getEmail());
        account.setFirstName(signUpDto.getFirstName());
        account.setLastName(signUpDto.getLastName());
        account.setPassword(passwordEncoder.encode(signUpDto.getPassword()));
        account.setActive(true);

        Role roles = roleRepo.findRolesByRoleName("ROLE_ADMIN").get();
        account.setRoles(Collections.singleton(roles));

        accountRepo.save(account);

        return new ResponseEntity<>("Account registered successfully", HttpStatus.OK);
    }
}
