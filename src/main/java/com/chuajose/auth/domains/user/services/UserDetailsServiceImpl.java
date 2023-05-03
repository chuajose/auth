package com.chuajose.auth.domains.user.services;

import com.chuajose.auth.domains.auth.models.Auth;
import com.chuajose.auth.domains.auth.repositories.AuthRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final AuthRepository authRepository;

    public UserDetailsServiceImpl(AuthRepository userRepository) {
        this.authRepository = userRepository;
    }

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final Auth user = authRepository.findUserByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        System.out.println("El usuarui exiset");

        return org.springframework.security.core.userdetails.User.withUsername(
                user.getUsername()).password(user.getPasswordHash()).roles("USER").build();
    }

    public UserDetails loadUserByEmail(String email) throws UsernameNotFoundException {
        final Auth user = authRepository.findUserByEmail(email);

        if (user == null) {
            throw new UsernameNotFoundException(email);
        }
        System.out.println("El usuarui exiset");

        return org.springframework.security.core.userdetails.User.withUsername(
                user.getUsername()).password(user.getPasswordHash()).roles("USER").build();
    }
}
