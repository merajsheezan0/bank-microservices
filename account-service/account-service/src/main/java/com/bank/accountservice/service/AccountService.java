package com.bank.accountservice.service;

import com.bank.accountservice.dto.Customer;
import com.bank.accountservice.model.Account;
import com.bank.accountservice.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository repo;
    private final RestTemplate restTemplate;

    // Validate customer using Customer Service
    private Customer validateCustomer(Long customerId) {
        String url = "http://localhost:8081/customers/" + customerId;
        try {
            return restTemplate.getForObject(url, Customer.class);
        } catch (Exception e) {
            throw new RuntimeException("Invalid customer ID: " + customerId);
        }
    }

    public Account createAccount(Long customerId) {
        validateCustomer(customerId);
        Account account = new Account();
        account.setCustomerId(customerId);
        account.setBalance(0.0);
        return repo.save(account);
    }

    public Account getAccount(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Account not found"));
    }

    public Account addMoney(Long id, Double amount) {
        Account account = getAccount(id);
        account.setBalance(account.getBalance() + amount);
        return repo.save(account);
    }

    public Account withdrawMoney(Long id, Double amount) {
        Account account = getAccount(id);
        if (account.getBalance() < amount)
            throw new RuntimeException("Insufficient balance!");
        account.setBalance(account.getBalance() - amount);
        return repo.save(account);
    }

    public void deleteAccount(Long id) {
        repo.deleteById(id);
    }
}
