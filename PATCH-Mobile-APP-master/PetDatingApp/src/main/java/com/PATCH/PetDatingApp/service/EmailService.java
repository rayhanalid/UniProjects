/*
package com.PATCH.PetDatingApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendResetPasswordEmail(EmailRequest request) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("your@email.com");
        message.setTo(request.getEmail());
        message.setSubject("Reset your password");
        message.setText("To reset your password, please click the link below:\n" +
                "http://localhost:8080/reset?token=" + request.getToken());

        javaMailSender.send(message);
    }
}
*/
