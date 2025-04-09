package com.example.guntuk.udyog.controller;


import com.example.guntuk.udyog.model.ContactMessage;
import com.example.guntuk.udyog.repository.ContactMessageRepository;
import com.example.guntuk.udyog.service.ContactMessageService;
import com.example.guntuk.udyog.service.emailService;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController

@RequestMapping("/api/contact")
public class ContactController {

    @Autowired
    private ContactMessageService contactMessageService;
    @Autowired
    private emailService emailService;

    @PostMapping("/add")
    public ResponseEntity<Map<String, String>> submitMessage(@RequestBody ContactMessage contactMessage) {
        System.out.println(contactMessage);
        contactMessageService.saveContactMessage(contactMessage);

        val mail=contactMessage.getEmail();
emailService.sendEmail(mail,"welcome to guntuk ","we got your msg thanks for feedback");



        Map<String, String> response = new HashMap<>();
        response.put("message", "Message submitted successfully");

        return ResponseEntity.ok(response);
    }

    @GetMapping("/test")
    public ResponseEntity<String> testEndpoint() {
        return ResponseEntity.ok("API is working!");
    }

    @GetMapping("/showAll")
    public List<ContactMessage> showAll() {
       return contactMessageService.ShowAll();
    }


}
