package com.example.guntuk.udyog.repository;


import com.example.guntuk.udyog.model.ContactMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactMessageRepository extends JpaRepository<ContactMessage, Long> {
    // You can define custom queries if needed

}
