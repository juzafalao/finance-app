package br.com.familyfinance.financeapp.repository;

import br.com.familyfinance.financeapp.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
