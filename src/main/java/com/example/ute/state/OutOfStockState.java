package com.example.ute.state;

import com.example.ute.product.Product;
import com.example.ute.singleton.VendingMachine;

public class OutOfStockState implements VendingMachineState {
    @Override
    public void selectProduct(VendingMachine vm, Product p) {
        if (vm == null || p == null) {
            return;
        }
        if (vm.getInventory().checkStock(p)) {
            vm.setState(new ReadyState());
            vm.selectProduct(p);
            return;
        }
        System.out.println("Still out of stock: " + p.getName());
    }

    @Override
    public void insertMoney(VendingMachine vm, double amount) {
        System.out.println("Cannot accept money. Product out of stock.");
    }

    @Override
    public void dispense(VendingMachine vm) {
        System.out.println("Cannot dispense. Product out of stock.");
    }
}


