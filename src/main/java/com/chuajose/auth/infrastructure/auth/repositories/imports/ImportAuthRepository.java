package com.chuajose.auth.infrastructure.auth.repositories.imports;

import com.chuajose.auth.domains.auth.models.Auth;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImportAuthRepository extends JpaRepository<Auth, Long> {
    Auth findUserByUsername(String username);
    Auth findUserByEmail(String email);

}
