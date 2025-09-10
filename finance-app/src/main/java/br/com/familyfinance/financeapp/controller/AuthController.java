package br.com.familyfinance.financeapp.controller;

import br.com.familyfinance.financeapp.dto.LoginRequest;
import br.com.familyfinance.financeapp.dto.LoginResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) {
        // Em uma aplicação real, você validaria o usuário e geraria um JWT.
        String token = "fake-token-for-" + request.getUsername();
        return ResponseEntity.ok(new LoginResponse(token));
    }
}
