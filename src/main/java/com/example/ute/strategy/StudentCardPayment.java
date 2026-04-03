package com.example.ute.strategy;

public class StudentCardPayment implements PaymentStrategy {
    @Override
    public boolean pay(double amount) {
        System.out.println("Student card charged: " + amount);
        return true;
    }
}


