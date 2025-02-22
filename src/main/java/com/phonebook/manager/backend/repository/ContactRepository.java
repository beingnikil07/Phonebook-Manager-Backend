package com.phonebook.manager.backend.repository;

import com.phonebook.manager.backend.Entity.Contact;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource(path ="contacts",collectionResourceRel ="contacts")
public interface ContactRepository extends JpaRepository<Contact,String> {

    @RestResource(path ="by-email")
    List<Contact> findByEmail(@Param("email") String email,Pageable pageable);

    @RestResource(path ="by-phone",rel ="by-phone")
    List<Contact>  findByPhoneNumberContainingIgnoreCase(@Param("phone") String phoneNumber, Pageable pageable);

    @RestResource(path ="by-name")
    List<Contact> findByNameContainingIgnoreCase(@Param("name") String name,Pageable pageable);
}
