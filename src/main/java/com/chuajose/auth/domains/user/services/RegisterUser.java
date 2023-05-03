package com.chuajose.auth.domains.user.services;

import com.chuajose.auth.domains.shared.services.EmailService;
import com.chuajose.auth.domains.user.models.User;
import com.chuajose.auth.domains.user.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;

@Service
public class RegisterUser {

    private final UserRepository userRepository;
    private final EmailService emailSender;

    @Autowired
    RegisterUser(final  UserRepository authRepository, EmailService emailSender){
        this.userRepository = authRepository;
        this.emailSender = emailSender;
    }
    public User execute(User user){
        this.userRepository.create(user);
       // emailSender.sendSimpleMessage(user.getEmail(), "REGISTRO", "Bienvenido");
        try {
            Map<String, Object> templateModel = new HashMap<>();
            templateModel.put("recipientName", "para ti");
            templateModel.put("text", "con este texto");
            templateModel.put("senderName", "tyo");
            emailSender.sendMessageUsingFreemarkerTemplate(user.getEmail(), "REGISTRO", templateModel);
        }catch (Exception exception){
            System.out.println(exception.getMessage());
        }



        return user;
    }
}
