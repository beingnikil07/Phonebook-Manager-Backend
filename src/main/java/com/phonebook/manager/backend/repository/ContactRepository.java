package com.phonebook.manager.backend.repository;

import com.phonebook.manager.backend.Entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path ="contacts",collectionResourceRel ="contacts")
public interface ContactRepository extends JpaRepository<Contact,String> {

    Contact findByEmail(String email);

    Contact findByPhoneNumber(String phoneNumber);

}
