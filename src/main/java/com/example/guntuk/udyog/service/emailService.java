package com.example.guntuk.udyog.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class emailService {
    @Autowired
    JavaMailSender javaMailSender;

    public void sendEmail(String to,String subject,String body){
        try {

            SimpleMailMessage mail =new SimpleMailMessage();

            mail.setTo(to);
            mail.setSubject(subject);
            mail.setText(body);
            javaMailSender.send(mail);

        } catch (Exception e) {
            log.error("exception while sending mail",e);
        }
    }
}
