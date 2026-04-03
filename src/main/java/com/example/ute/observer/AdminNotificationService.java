package com.example.ute.observer;

import com.example.ute.product.Product;

public class AdminNotificationService implements InventoryObserver {
    @Override
    public void update(Product p, int currentStock) {
        String productName = p == null ? "Unknown" : p.getName();
        System.out.println("[Admin] Low stock for " + productName + ": " + currentStock);
    }
}


