package com.bank.accountservice.controller;

import com.bank.accountservice.model.Account;
import com.bank.accountservice.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/accounts")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService service;

    @PostMapping("/create/{customerId}")
    public Account create(@PathVariable Long customerId) {
        return service.createAccount(customerId);
    }

    @GetMapping("/{id}")
    public Account get(@PathVariable Long id) {
        return service.getAccount(id);
    }

    @PutMapping("/{id}/add")
    public Account addMoney(@PathVariable Long id, @RequestParam Double amount) {
        return service.addMoney(id, amount);
    }

    @PutMapping("/{id}/withdraw")
    public Account withdraw(@PathVariable Long id, @RequestParam Double amount) {
        return service.withdrawMoney(id, amount);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteAccount(id);
    }
}
