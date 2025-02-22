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

@Entity
@Table(name ="user_contacts")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Contact {
    @Id
    private String id;
    @NotBlank(message = "Contact name is required")
    @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters")
    private String name;
    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    private String email;
    @NotBlank(message = "Phone number is required")
    @Pattern(regexp = "^[0-9]{10}$", message = "Phone number must be a 10-digit number")
    private String phoneNumber;
    @Size(max = 255, message = "Address must not exceed 255 characters")
    private String address;
    @Column(length = 100)
    private String picture;
    @Lob
    @Size(max = 500, message = "Description should not exceed 500 characters")
    private String description;

    private boolean favorite;
    @Pattern(regexp = "^(https?|ftp)://[^\\s/$.?#].[^\\s]*$", message = "Invalid website URL")
    private String websiteLink;
    @Pattern(regexp = "^(https?://)?(www\\.)?linkedin\\.com/.*$", message = "Invalid LinkedIn profile link")
    private String LinkedInLink;
    @Pattern(regexp = "^(https?://)?(www\\.)?instagram\\.com/.*$", message = "Invalid Instagram profile link")
    private String instagramLink;

    //mapping to User
    @ManyToOne
    private User user;
}
