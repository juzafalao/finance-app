package br.com.familyfinance.financeapp.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import br.com.familyfinance.financeapp.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
    boolean existsByUsername(String username);
}
