package com.chuajose.auth.infrastructure.user.repositories;

import com.chuajose.auth.domains.user.models.User;
import com.chuajose.auth.domains.user.repositories.UserRepository;
import com.chuajose.auth.infrastructure.user.repositories.imports.ImportUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserJpaRepository implements UserRepository {
    final ImportUserRepository imp;

    @Autowired
    public UserJpaRepository(ImportUserRepository imp) {
        this.imp = imp;
    }


    @Override
    public User create(User user) {
        imp.save(user);
        return user;
    }

    @Override
    public User findByUsername(String username) {
        return imp.findByUsername(username);
    }


}
