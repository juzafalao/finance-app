package br.com.familyfinance.financeapp.repository;

import br.com.familyfinance.financeapp.entity.Transaction;
import br.com.familyfinance.financeapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findByUser(User user);
    List<Transaction> findByUserAndDateBetween(User user, LocalDate start, LocalDate end);
}
