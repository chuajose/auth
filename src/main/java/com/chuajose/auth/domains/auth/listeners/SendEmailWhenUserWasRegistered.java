package com.chuajose.auth.domains.auth.listeners;

import com.chuajose.auth.domains.auth.events.UserWasRegistered;
import com.chuajose.auth.domains.shared.services.EmailService;
import com.chuajose.auth.domains.user.models.User;
import org.jetbrains.annotations.NotNull;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class SendEmailWhenUserWasRegistered {
    private final EmailService emailSender;

    public SendEmailWhenUserWasRegistered(EmailService emailSender) {
        this.emailSender = emailSender;
    }

    @EventListener
    @Async
    public void onApplicationEvent(@NotNull UserWasRegistered event) {
        try {
            User user = event.getUser();
            Map<String, Object> templateModel = new HashMap<>();
            templateModel.put("recipientName", "para ti");
            templateModel.put("text", "con este texto");
            templateModel.put("senderName", "tyo");
            emailSender.sendMessageUsingFreemarkerTemplate(user.getEmail(), "REGISTRO", templateModel);
        }catch (Exception exception){
            System.out.println(exception.getMessage());
        }
    }
}
