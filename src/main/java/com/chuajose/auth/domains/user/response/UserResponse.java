package com.chuajose.auth.domains.user.response;

import com.chuajose.auth.domains.user.models.User;

public class UserResponse {

    private final User user;

    public UserResponse(User user) {
        this.user = user;
    }

    public String getUsername(){
        return user.getUsername();
    }
}
