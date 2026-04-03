package com.example.ute.strategy;

public class EWalletPayment implements PaymentStrategy {
    @Override
    public boolean pay(double amount) {
        System.out.println("E-wallet charged: " + amount);
        return true;
    }
}


