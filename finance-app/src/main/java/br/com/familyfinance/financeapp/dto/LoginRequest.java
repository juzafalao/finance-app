package br.com.familyfinance.financeapp.dto;

import lombok.*;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class LoginRequest {
    private String username;
    private String password;
}
