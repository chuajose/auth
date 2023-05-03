package com.chuajose.auth.infrastructure.auth.repositories;

import com.chuajose.auth.domains.auth.models.Auth;
import com.chuajose.auth.domains.auth.repositories.AuthRepository;
import com.chuajose.auth.infrastructure.auth.repositories.imports.ImportAuthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthJpaRepository implements AuthRepository {

    private final ImportAuthRepository impl;

    @Autowired
    public AuthJpaRepository(ImportAuthRepository impl) {
        this.impl = impl;
    }

    @Override
    public Optional<Auth> findById(Long id) {
        System.out.println("Busco la que tiene id "+id+" y no existe");
        return impl.findById(id);
    }

    @Override
    public Auth findUserByUsername(String username) {
        return impl.findUserByUsername(username);
    }

    @Override
    public Auth findUserByEmail(String email) {
        return impl.findUserByEmail(email);

    }
}
