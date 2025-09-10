package br.com.familyfinance.financeapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheckController {

    @GetMapping("/health")
    public String health() {
        // mesma mensagem verificada pelo teste
        return "API online 🚀";
    }
}
