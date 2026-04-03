package com.example.ute.state;

import com.example.ute.product.Product;
import com.example.ute.singleton.VendingMachine;

public class ReadyState implements VendingMachineState {
    @Override
    public void selectProduct(VendingMachine vm, Product p) {
        if (vm == null || p == null) {
            return;
        }
        if (!vm.getInventory().checkStock(p)) {
            System.out.println("Product out of stock: " + p.getName());
            vm.setState(new OutOfStockState());
            return;
        }
        vm.setSelectedProduct(p);
        System.out.println("Selected: " + p.getName());
        vm.setState(new ProcessingPaymentState());
    }

    @Override
    public void insertMoney(VendingMachine vm, double amount) {
        System.out.println("Select a product first.");
    }

    @Override
    public void dispense(VendingMachine vm) {
        System.out.println("Payment required.");
    }
}


