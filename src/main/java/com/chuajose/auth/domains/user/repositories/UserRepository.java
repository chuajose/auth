package com.chuajose.auth.domains.user.repositories;

import com.chuajose.auth.domains.user.models.User;

public interface UserRepository {

    User create(User user);

    User findByUsername(String username);
}
