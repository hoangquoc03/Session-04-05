package org.example.bankingdockercompose.controller;


import org.example.bankingdockercompose.entity.Account;
import org.example.bankingdockercompose.service.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    private final AccountService service;

    public AccountController(AccountService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Account> create(@RequestBody Account account) {
        return ResponseEntity.ok(service.create(account));
    }

    @GetMapping
    public List<Account> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Account> getById(@PathVariable Long id) {
        return service.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}