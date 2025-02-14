package com.phonebook.manager.backend.repository;

import com.phonebook.manager.backend.Entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact,String> {
}
