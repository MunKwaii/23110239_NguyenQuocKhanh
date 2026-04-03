package com.example.ute.state;

import com.example.ute.product.Product;
import com.example.ute.singleton.VendingMachine;

public class ProcessingPaymentState implements VendingMachineState {
    @Override
    public void selectProduct(VendingMachine vm, Product p) {
        System.out.println("Payment in progress. Complete payment before changing product.");
    }

    @Override
    public void insertMoney(VendingMachine vm, double amount) {
        if (vm == null || amount <= 0) {
            return;
        }
        vm.addBalance(amount);
        Product selected = vm.getSelectedProduct();
        if (selected == null) {
            System.out.println("No product selected.");
            return;
        }
        System.out.println("Inserted: " + amount + ", balance: " + vm.getCurrentBalance());
        if (vm.getCurrentBalance() >= selected.getPrice()) {
            vm.executePayment();
        }
    }

    @Override
    public void dispense(VendingMachine vm) {
        System.out.println("Payment not completed yet.");
    }
}


