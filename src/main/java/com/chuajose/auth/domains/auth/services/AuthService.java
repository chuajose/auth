package com.chuajose.auth.domains.auth.services;

import com.chuajose.auth.domains.auth.models.Auth;
import com.chuajose.auth.domains.auth.repositories.AuthRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
@Service
public class AuthService {
    private final AuthRepository userRepository;

    public AuthService(final AuthRepository userRepository) {
        this.userRepository = userRepository;
    }



    public Auth get(final Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public Auth getUserByUsername(String username) {
        return userRepository.findUserByUsername(username);
    }


}
