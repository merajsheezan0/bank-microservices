package com.bank.customerservice.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@RefreshScope
@Component
public class GreetingService {

    @Value("${greeting.message}")
    private String message;

    public String getMessage() {
        return message;
    }
}
