package com.example.ute.strategy;

public class CashPayment implements PaymentStrategy {
    @Override
    public boolean pay(double amount) {
        System.out.println("Cash payment accepted: " + amount);
        return true;
    }
}


