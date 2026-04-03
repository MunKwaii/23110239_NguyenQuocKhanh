package com.example.ute.factory;

import com.example.ute.product.MineralWater;
import com.example.ute.product.Product;
import com.example.ute.product.SoftDrink;
import com.example.ute.product.Tea;

public class ProductFactory {
    public Product createProduct(String type) {
        if (type == null) {
            return null;
        }

        String normalized = type.trim().toLowerCase();
        switch (normalized) {
            case "tea":
                return new Tea();
            case "softdrink":
            case "soft drink":
            case "soft_drink":
                return new SoftDrink();
            case "mineralwater":
            case "mineral water":
            case "mineral_water":
                return new MineralWater();
            default:
                return null;
        }
    }
}


