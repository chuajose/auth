package com.chuajose.auth.ui.rest.controllers.auth.request;

import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
public class LoginRequest {
    @NotNull
    @Length(min = 1, max = 50)
    private String email;

    @NotNull @Length(min = 5, max = 10)
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
