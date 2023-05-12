package com.group08.onlineShop.service;

import com.group08.onlineShop.model.Account;
import jakarta.mail.MessagingException;

public interface MailService {
    void sendMailForgotPassword(String body, String subject, String email) throws MessagingException;
}
