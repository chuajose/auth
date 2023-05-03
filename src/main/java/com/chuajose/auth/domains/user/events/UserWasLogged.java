package com.chuajose.auth.domains.user.events;

import com.chuajose.auth.domains.user.models.User;
import org.springframework.context.ApplicationEvent;

public class UserWasLogged extends ApplicationEvent {
    private final User user;
    public UserWasLogged(Object source, User user) {
        super(source);
        this.user = user;
    }

    public User getUser(){
        return user;
    }
}
