package com.example.ute.state;

import com.example.ute.product.Product;
import com.example.ute.singleton.VendingMachine;

public interface VendingMachineState {
    void selectProduct(VendingMachine vm, Product p);
    void insertMoney(VendingMachine vm, double amount);
    void dispense(VendingMachine vm);
}


