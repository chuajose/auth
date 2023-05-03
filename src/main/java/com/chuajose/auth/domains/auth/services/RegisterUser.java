package com.chuajose.auth.domains.auth.services;

import com.chuajose.auth.domains.auth.events.UserWasRegistered;
import com.chuajose.auth.domains.user.models.User;
import com.chuajose.auth.domains.user.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
public class RegisterUser {

    private final UserRepository userRepository;
    private final ApplicationEventPublisher applicationEventPublisher;

    @Autowired
    RegisterUser(final  UserRepository authRepository, ApplicationEventPublisher applicationEventPublisher){
        this.userRepository = authRepository;
        this.applicationEventPublisher = applicationEventPublisher;
    }
    public User execute(User user){
        this.userRepository.create(user);
        applicationEventPublisher.publishEvent(new UserWasRegistered(this, user));
        return user;
    }
}
