package com.example.guntuk.udyog.service;


import com.example.guntuk.udyog.model.ContactMessage;
import com.example.guntuk.udyog.repository.ContactMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactMessageService {

    @Autowired
    private ContactMessageRepository contactMessageRepository;

    // Method to save the contact message
    public void saveContactMessage(ContactMessage contactMessage) {
        contactMessageRepository.save(contactMessage);
    }
}
