package com.example.ute.observer;

import com.example.ute.product.Product;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class InventoryManager {
    private final Map<Product, Integer> stockMap = new LinkedHashMap<>();
    private final List<InventoryObserver> observers = new ArrayList<>();

    public void addObserver(InventoryObserver o) {
        if (o != null && !observers.contains(o)) {
            observers.add(o);
        }
    }

    public void addStock(Product p, int quantity) {
        if (p == null || quantity <= 0) {
            return;
        }
        int current = stockMap.getOrDefault(p, 0);
        stockMap.put(p, current + quantity);
    }

    public boolean checkStock(Product p) {
        return stockMap.getOrDefault(p, 0) > 0;
    }

    public void reduceStock(Product p) {
        if (p == null) {
            return;
        }
        int current = stockMap.getOrDefault(p, 0);
        if (current <= 0) {
            notifyLowStock(p);
            return;
        }
        int newStock = current - 1;
        stockMap.put(p, newStock);
        if (newStock == 0) {
            notifyLowStock(p);
        }
    }

    public Map<Product, Integer> getStockSnapshot() {
        return new LinkedHashMap<>(stockMap);
    }

    private void notifyLowStock(Product p) {
        int current = stockMap.getOrDefault(p, 0);
        for (InventoryObserver observer : observers) {
            observer.update(p, current);
        }
    }
}


