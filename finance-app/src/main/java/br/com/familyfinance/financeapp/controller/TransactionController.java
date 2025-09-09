// src/main/java/br/com/familyfinance/financeapp/controller/TransactionController.java
package br.com.familyfinance.financeapp.controller;

import java.security.Principal;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.familyfinance.financeapp.entity.User;
import br.com.familyfinance.financeapp.service.TransactionService;
import br.com.familyfinance.financeapp.service.UserService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/transactions")
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionService transactionService;
    private final UserService userService;

    @GetMapping("/me")
    public ResponseEntity<?> getMyTransactions(Principal principal) {
        User user = userService.findByUsername(principal.getName())
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
        return ResponseEntity.ok(transactionService.findByUser(user));
    }

    @PostMapping
    public ResponseEntity<?> createTransaction(@RequestBody /*Transaction dto or entity*/ Object body, Principal principal) {
        User user = userService.findByUsername(principal.getName())
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
        // adapte aqui conforme sua assinatura real:
        return ResponseEntity.ok(transactionService.createForUser(user, body));
    }
}