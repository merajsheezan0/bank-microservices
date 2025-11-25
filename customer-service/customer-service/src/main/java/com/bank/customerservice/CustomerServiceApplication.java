package com.bank.customerservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication
public class CustomerServiceApplication {

	public static void main(String[] args) {
		//SpringApplication.run(CustomerServiceApplication.class, args);
	}

    public void dummyMethod(String arg) {
        char startParenthesis = '(';
        char endParenthesis = ')';
        int startParenthesisCount = 0;
        int endParenthesisCount = 0;
        for (char ch : arg.toCharArray()) {
            if (ch == endParenthesis && endParenthesisCount == 0 && startParenthesisCount == 0) {
                arg.replaceFirst(String.valueOf(endParenthesis), "");
            } else {
                if (ch == startParenthesis) {
                    startParenthesisCount++;
                } else if (ch == endParenthesis) {
                    endParenthesisCount++;
                }
            }
        }
        System.out.println(arg);
    }

}
