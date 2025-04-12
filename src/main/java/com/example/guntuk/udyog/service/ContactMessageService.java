package com.example.guntuk.udyog.service;


import com.example.guntuk.udyog.model.ContactMessage;
import com.example.guntuk.udyog.repository.ContactMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactMessageService {

    @Autowired
    private ContactMessageRepository contactMessageRepository;

    // Method to save the contact message
    public void saveContactMessage(ContactMessage contactMessage) {

        contactMessageRepository.save(contactMessage);


    }
    public List<ContactMessage> ShowAll(){
       List<ContactMessage>list= contactMessageRepository.findAll();
        return list;
    }
}
