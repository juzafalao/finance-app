package br.com.familyfinance.financeapp.repository;

import br.com.familyfinance.financeapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {

    // Busca usuário pelo e-mail (usado como login)
    Optional<User> findByEmail(String email);
}
