package com.example.guntuk.udyog.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "msg")  // Name of the table in the database
@NoArgsConstructor
public class ContactMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Auto-generated primary key
    private Long id;

    private String name;
    private String email;
    private String message;
    private String mobile;  // New field for mobile number

    // Constructors, Getters, Setters
}
