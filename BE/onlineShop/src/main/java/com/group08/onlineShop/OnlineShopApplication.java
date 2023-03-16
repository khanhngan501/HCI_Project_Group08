package com.group08.onlineShop;

import com.group08.onlineShop.model.Account;
import com.group08.onlineShop.model.Role;
import com.group08.onlineShop.service.AccountService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

@SpringBootApplication
public class OnlineShopApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlineShopApplication.class, args);
	}

	@Bean
	CommandLineRunner run(AccountService accountService) {

        return args -> {
//			accountService.saveRole(new Role(null, "ROLE_USER"));
//			accountService.saveRole(new Role(null, "ROLE_MANAGER"));
//			accountService.saveRole(new Role(null, "ROLE_ADMIN"));
//			accountService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));

//			accountService.saveUser(Account.builder()
//                    .name("Nguuyễn Văn A")
//                    .roles(new ArrayList<>())
//                    .enable(true)
//                    .username("nguyenvana@gmail.com")
//                    .password("12345")
//                    .build());

			accountService.addRoleToUser("nguyenvana@gmail.com",
                    "ROLE_USER");
//            customerService.addRoleToUser("trinh@gmail.com",
//                    "ROLE_USER");
//
//            accountService.saveUser(AccountApp.builder()
//                    .username("thng1642@gmail.com")
//                    .password("456852")
//                    .enable(true)
//                    .roles(new ArrayList<>())
//                    .name("Nguyễn Thuận")
//                    .build());
//
//            accountService.addRoleToUser("thng1642@gmail.com",
//                    "ROLE_MANAGER");
//            accountService.addRoleToUser("thng1642@gmail.com",
//                    "ROLE_USER");

//            accountService.saveUser(AccountApp.builder()
//                    .name("Nguyễn Thuận")
//                    .roles(new ArrayList<>())
//                    .enable(true)
//                    .username("thng1642@gmail.com")
//                    .password("12345")
//                    .build());

//            accountService.addRoleToUser("thng1642@gmail.com",
//                    "ROLE_SUPER_ADMIN");
        };
    }

}
