package br.com.familyfinance.financeapp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.com.familyfinance.financeapp.entity.Role;
import br.com.familyfinance.financeapp.entity.User;
import br.com.familyfinance.financeapp.service.CustomUserDetailsService;
import lombok.RequiredArgsConstructor;

@SpringBootApplication
public class FinanceAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(FinanceAppApplication.class, args);
    }

    @Bean
    CommandLineRunner seedAdmin(CustomUserDetailsService users) {
        return args -> {
            String adminUser = "admin";
            if (!users.loadUserByUsername(adminUser).isEnabled()) {
                // a chamada acima lança exceção se não existir; tratamos assim:
            };
        };
    }
}
