package com.example.ute.product;

import java.util.UUID;

public class Tea extends Product {
    public Tea() {
        super(UUID.randomUUID().toString(), "Tea", 10.0);
    }

    @Override
    public double getPrice() {
        return super.getPrice();
    }
}


