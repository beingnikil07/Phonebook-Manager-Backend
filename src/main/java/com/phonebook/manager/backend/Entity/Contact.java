package com.phonebook.manager.backend.Entity;

import jakarta.persistence.*;

@Entity
@Table(name ="user_contacts")
public class Contact {
    @Id
    private String id;
    private String name;
    private String email;
    private String phoneNumber;
    private String address;
    private String picture;
    @Lob
    private String description;

    private boolean favorite;
    private String websiteLink;
    private String LinkedInLink;
    private String instagramLink;

    //mapping to User
    @ManyToOne
    private User user;
}
