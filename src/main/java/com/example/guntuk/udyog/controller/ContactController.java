package com.example.guntuk.udyog.controller;


import com.example.guntuk.udyog.model.ContactMessage;
import com.example.guntuk.udyog.repository.ContactMessageRepository;
import com.example.guntuk.udyog.service.ContactMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController

@RequestMapping("/api/contact")
public class ContactController {

    @Autowired
    private ContactMessageService contactMessageService;

    @PostMapping("/add")
    public ResponseEntity<String> submitMessage(@RequestBody ContactMessage contactMessage) {
        System.out.println(contactMessage);
        contactMessageService.saveContactMessage(contactMessage);
        return ResponseEntity.ok("Message submitted successfully");
    }

    @GetMapping("/test")
    public ResponseEntity<String> testEndpoint() {
        return ResponseEntity.ok("API is working!");
    }
}
