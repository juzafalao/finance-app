// src/main/java/br/com/familyfinance/financeapp/service/TransactionService.java
package br.com.familyfinance.financeapp.service;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.familyfinance.financeapp.entity.User;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TransactionService {

    public List<Object> findByUser(User user) {
        // implemente de acordo com seu domínio
        return Collections.emptyList();
    }

    public Object createForUser(User user, Object body) {
        // implemente de acordo com seu domínio
        return body;
    }
}
