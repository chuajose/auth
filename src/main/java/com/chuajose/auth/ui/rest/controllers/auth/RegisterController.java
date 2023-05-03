package com.chuajose.auth.ui.rest.controllers.auth;

import com.chuajose.auth.domains.user.models.User;
import com.chuajose.auth.domains.user.services.RegisterUser;
import com.chuajose.auth.ui.rest.controllers.ApiController;
import com.chuajose.auth.ui.rest.controllers.auth.request.RegisterRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegisterController extends ApiController {

    @Autowired
    final RegisterUser registerUser;

    public RegisterController(RegisterUser registerUser) {
        this.registerUser = registerUser;
    }

    @PostMapping("register")
    public ResponseEntity<User> registerUser(@Valid @RequestBody RegisterRequest request) {
        User user =   new User(request.getUsername(), request.getEmail(), new BCryptPasswordEncoder().encode(request.getPassword()));
        registerUser.execute(user);
        return ResponseEntity.ok().body(user);
    }
}
