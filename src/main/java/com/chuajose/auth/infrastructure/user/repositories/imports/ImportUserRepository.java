package com.chuajose.auth.infrastructure.user.repositories.imports;

import com.chuajose.auth.domains.user.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImportUserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);
}
