package com.chuajose.auth.ui.rest.controllers.auth;

import com.chuajose.auth.config.jwt.JwtTokenUtil;
import com.chuajose.auth.domains.auth.models.Auth;
import com.chuajose.auth.domains.auth.response.AuthResponse;
import com.chuajose.auth.domains.auth.services.AuthService;
import com.chuajose.auth.ui.rest.controllers.auth.request.LoginRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    AuthenticationManager authManager;
    @Autowired
    final AuthService authService;
    @Autowired
    JwtTokenUtil jwtUtil;

    public LoginController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/auth/login")
    public ResponseEntity<?> login(@RequestBody @Valid LoginRequest request){
        try {
            Authentication authentication = authManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getEmail(), request.getPassword())
            );
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            Auth user = authService.getUserByUsername(userDetails.getUsername());
            String accessToken = jwtUtil.generateAccessToken(user);
            String refreshToken = jwtUtil.generateRefreshToken(user);
            AuthResponse response = new AuthResponse(user.getEmail(), accessToken, refreshToken);
            return ResponseEntity.ok().body(response);

        } catch (BadCredentialsException ex) {

            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
}
