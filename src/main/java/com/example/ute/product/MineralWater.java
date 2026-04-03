package com.example.ute.product;

import java.util.UUID;

public class MineralWater extends Product {
    public MineralWater() {
        super(UUID.randomUUID().toString(), "Mineral Water", 8.0);
    }

    @Override
    public double getPrice() {
        return super.getPrice();
    }
}


