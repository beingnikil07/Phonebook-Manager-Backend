package com.phonebook.manager.backend.Entity;

import jakarta.persistence.*;

@Entity
@Table(name ="users")
public class User {
    @Id
    private String id;
    @Column(nullable = false)
    private String name;
    @Column(unique = true,nullable = false)
    private String email;

    private String password;

    @Lob
    private String about;

    @Column(length =1000)
    private String profilePicture;
    private String phoneNumber;

    // These boolean flags store whether the user account is enabled and if the email/phone is verified.
    private boolean enabled=true;
    private boolean emailVerified=false;
    private boolean phoneVerified=false;

    @Enumerated(value =EnumType.STRING)
    private Providers provider=Providers.SELF;
    //For Email Verification Token
    private String emailToken;

}
