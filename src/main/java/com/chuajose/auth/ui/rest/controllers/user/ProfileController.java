package com.chuajose.auth.ui.rest.controllers.user;

import com.chuajose.auth.domains.user.repositories.UserRepository;
import com.chuajose.auth.domains.user.response.UserResponse;
import com.chuajose.auth.ui.rest.controllers.ApiController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProfileController  extends ApiController {
    @Autowired
    UserRepository userRepository;

    @GetMapping("profile")
    public ResponseEntity<UserResponse> registerUser() {
        UserDetails principal = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        UserResponse response = new UserResponse(this.userRepository.findByUsername(principal.getUsername()));
        return ResponseEntity.ok().body(response);

    }
}
