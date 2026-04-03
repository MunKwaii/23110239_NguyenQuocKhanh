package com.example.ute.observer;

import com.example.ute.product.Product;

public interface InventoryObserver {
    void update(Product p, int currentStock);
}


