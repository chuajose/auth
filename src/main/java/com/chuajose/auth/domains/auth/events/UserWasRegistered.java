package com.chuajose.auth.domains.auth.events;

import com.chuajose.auth.domains.user.models.User;
import org.springframework.context.ApplicationEvent;

public class UserWasRegistered extends ApplicationEvent {

    private final User user;
    public UserWasRegistered(Object source, User user) {
        super(source);
        this.user = user;
    }

    public User getUser(){
        return user;
    }
}
