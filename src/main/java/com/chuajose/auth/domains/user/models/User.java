package com.chuajose.auth.domains.user.models;

import com.chuajose.auth.domains.auth.models.Auth;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class User extends Auth {
    @Column(nullable = true, unique = false)
    private String extra;

    public User(String name, String email, String password ){
        this.username = name;
        this.email = email;
        this.passwordHash = password;
    }

    public User() {

    }

    public String getExtra(){
        return extra;
    }
}
