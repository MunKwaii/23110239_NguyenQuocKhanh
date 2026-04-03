package com.example.ute.state;

import com.example.ute.product.Product;
import com.example.ute.singleton.VendingMachine;

public class DispensingState implements VendingMachineState {
    @Override
    public void selectProduct(VendingMachine vm, Product p) {
        System.out.println("Dispensing in progress.");
    }

    @Override
    public void insertMoney(VendingMachine vm, double amount) {
        System.out.println("Dispensing in progress.");
    }

    @Override
    public void dispense(VendingMachine vm) {
        if (vm == null) {
            return;
        }
        Product selected = vm.getSelectedProduct();
        if (selected == null) {
            System.out.println("No product selected.");
            vm.setState(new ReadyState());
            return;
        }
        vm.getInventory().reduceStock(selected);
        System.out.println("Dispensed: " + selected.getName());
        vm.clearSelection();
        vm.resetBalance();
        vm.setState(new ReadyState());
    }
}


