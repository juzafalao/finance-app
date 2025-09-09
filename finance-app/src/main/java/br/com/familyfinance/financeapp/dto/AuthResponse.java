package br.com.familyfinance.financeapp.dto;

/**
 * Representa a resposta de autenticação contendo o token JWT gerado.
 * Inclui construtor vazio e construtor com token, além de getters e setters.
 */
public class AuthResponse {

    private String token;

    // Construtor vazio para frameworks (Jackson, etc.)
    public AuthResponse() {
    }

    // Construtor que recebe o token
    public AuthResponse(String token) {
        this.token = token;
    }

    // Getter
    public String getToken() {
        return token;
    }

    // Setter
    public void setToken(String token) {
        this.token = token;
    }
}
