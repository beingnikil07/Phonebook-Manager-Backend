package com.phonebook.manager.backend.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name ="users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    private String id;
    @Column(nullable = false)
    @NotBlank(message ="user is required")
    private String name;
    @Column(unique = true,nullable = false)
    @Email(message = "Invalid email format")
    @NotBlank(message = "Email is required")
    private String email;
    @NotBlank(message = "password is required")
    @Size(min = 8, message = "Password must be at least 8 characters long")
    private String password;

    @Lob
    private String about;

    @Column(length =1000)
    private String profilePicture;
    @Pattern(regexp = "^[0-9]{10}$", message = "Phone number must be a 10-digit number")
    private String phoneNumber;

    // These boolean flags store whether the user account is enabled and if the email/phone is verified.
    private boolean enabled=true;
    private boolean emailVerified=false;
    private boolean phoneVerified=false;

    @Enumerated(value =EnumType.STRING)
    private Providers provider=Providers.SELF;
    //For Email Verification Token
    private String emailToken;

    //mapping with Contact ,A user can have more than one contacts
    @OneToMany(mappedBy ="user",fetch =FetchType.LAZY,cascade =CascadeType.ALL,orphanRemoval = true)
    private Set<Contact> contacts=new LinkedHashSet<>();
}
