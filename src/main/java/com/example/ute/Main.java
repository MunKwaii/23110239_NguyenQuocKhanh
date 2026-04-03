package com.example.ute;

import com.example.ute.factory.ProductFactory;
import com.example.ute.observer.AdminNotificationService;
import com.example.ute.product.Product;
import com.example.ute.singleton.VendingMachine;
import com.example.ute.strategy.EWalletPayment;
import com.example.ute.strategy.StudentCardPayment;


public class Main {
    public static void main(String[] args) {
        ProductFactory factory = new ProductFactory();
        Product tea = factory.createProduct("tea");
        Product softDrink = factory.createProduct("soft drink");
        Product water = factory.createProduct("mineral water");

        VendingMachine machine = VendingMachine.getInstance();
        machine.getInventory().addObserver(new AdminNotificationService());
        machine.getInventory().addStock(tea, 2);
        machine.getInventory().addStock(softDrink, 1);
        machine.getInventory().addStock(water, 1);

        System.out.println("Available products:");
        machine.displayProducts();

        machine.setPaymentStrategy(new StudentCardPayment());
        machine.selectProduct(softDrink);
        machine.insertMoney(12.0);
        machine.dispense();

        machine.selectProduct(softDrink);
        machine.insertMoney(12.0);
        machine.dispense();

        machine.setPaymentStrategy(new EWalletPayment());
        machine.selectProduct(tea);
        machine.insertMoney(10.0);
        machine.dispense();
    }
}
