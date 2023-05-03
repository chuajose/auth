package com.chuajose.auth.domains.auth.repositories;

import com.chuajose.auth.domains.auth.models.Auth;

import java.util.Optional;

public interface AuthRepository  {
    Optional<Auth> findById(Long id);
    Auth findUserByUsername(String username);
    Auth findUserByEmail(String email);

}
