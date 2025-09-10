package br.com.familyfinance.financeapp.controller;

import br.com.familyfinance.financeapp.entity.User;
import br.com.familyfinance.financeapp.service.TransactionService;
import br.com.familyfinance.financeapp.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.security.Principal;

@RestController
@RequestMapping("/transactions")
public class TransactionController {
    private final TransactionService transactionService;
    private final UserService userService;

    public TransactionController(TransactionService transactionService, UserService userService) {
        this.transactionService = transactionService;
        this.userService = userService;
    }

    @GetMapping("/me")
    public ResponseEntity<?> getMyTransactions(Principal principal) {
        User user = userService.findByUsername(principal.getName())
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
        return ResponseEntity.ok(transactionService.findByUser(user));
    }

    @PostMapping
    public ResponseEntity<?> createTransaction(@RequestBody Object body, Principal principal) {
        User user = userService.findByUsername(principal.getName())
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
        return ResponseEntity.ok(transactionService.createForUser(user, body));
    }
}
