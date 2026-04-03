package com.example.ute.product;

import java.util.UUID;

public class SoftDrink extends Product {
    public SoftDrink() {
        super(UUID.randomUUID().toString(), "Soft Drink", 12.0);
    }

    @Override
    public double getPrice() {
        return super.getPrice();
    }
}


