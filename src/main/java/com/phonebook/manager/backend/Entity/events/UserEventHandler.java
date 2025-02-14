package com.phonebook.manager.backend.Entity.events;

import com.phonebook.manager.backend.Entity.User;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RepositoryEventHandler(User.class)
public class UserEventHandler {

    @HandleBeforeCreate
    public void handleBeforeSave(User user){
        user.setId(UUID.randomUUID().toString());
    }
}
