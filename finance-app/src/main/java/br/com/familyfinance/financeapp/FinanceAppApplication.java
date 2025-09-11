package br.com.familyfinance.financeapp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import br.com.familyfinance.financeapp.service.CustomUserDetailsService;

@SpringBootApplication
public class FinanceAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(FinanceAppApplication.class, args);
    }

    /**
     * Verifica na inicialização se o usuário admin existe.
     *
     * Caso não exista, apenas registra uma mensagem no log.
     * Caso exista, não faz nada.
     */
    @Bean
    CommandLineRunner seedAdmin(CustomUserDetailsService users) {
        return args -> {
            String adminEmail = "admin@example.com";
            try {
                var admin = users.loadUserByUsername(adminEmail);
                System.out.println("Admin encontrado: " + admin.getUsername());
            } catch (UsernameNotFoundException e) {
                System.out.println("Admin NÃO encontrado! Verifique se o data.sql foi executado corretamente.");
            }
        };
    }
}
