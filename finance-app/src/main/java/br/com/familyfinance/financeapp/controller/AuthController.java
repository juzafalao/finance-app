package br.com.familyfinance.financeapp.controller;

import br.com.familyfinance.financeapp.dto.LoginRequest;
import br.com.familyfinance.financeapp.dto.LoginResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) {
        // TODO: Substituir por autenticação real e geração de JWT
        String token = "fake-jwt-token-for-" + loginRequest.getUsername();
        return ResponseEntity.ok(new LoginResponse(token));
    }
}
