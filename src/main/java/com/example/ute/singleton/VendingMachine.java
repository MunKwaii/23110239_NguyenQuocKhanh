package com.example.ute.singleton;

import com.example.ute.observer.InventoryManager;
import com.example.ute.product.Product;
import com.example.ute.state.DispensingState;
import com.example.ute.state.ReadyState;
import com.example.ute.state.VendingMachineState;
import com.example.ute.strategy.CashPayment;
import com.example.ute.strategy.PaymentStrategy;

import java.util.Map;

public class VendingMachine {
    private static VendingMachine instance;
    private VendingMachineState currentState;
    private PaymentStrategy paymentStrategy;
    private final InventoryManager inventory;
    private Product selectedProduct;
    private double currentBalance;

    private VendingMachine() {
        this.inventory = new InventoryManager();
        this.currentState = new ReadyState();
        this.paymentStrategy = new CashPayment();
    }

    public static synchronized VendingMachine getInstance() {
        if (instance == null) {
            instance = new VendingMachine();
        }
        return instance;
    }

    public void displayProducts() {
        Map<Product, Integer> stock = inventory.getStockSnapshot();
        if (stock.isEmpty()) {
            System.out.println("No products available.");
            return;
        }
        for (Map.Entry<Product, Integer> entry : stock.entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();
            System.out.println(product.getName() + " - " + product.getPrice() + " (" + quantity + ")");
        }
    }

    public void setState(VendingMachineState s) {
        if (s != null) {
            this.currentState = s;
        }
    }

    public void setPaymentStrategy(PaymentStrategy ps) {
        if (ps != null) {
            this.paymentStrategy = ps;
        }
    }

    public void executePayment() {
        if (selectedProduct == null) {
            System.out.println("No product selected.");
            return;
        }
        if (paymentStrategy == null) {
            System.out.println("No payment method selected.");
            return;
        }
        boolean approved = paymentStrategy.pay(selectedProduct.getPrice());
        if (approved) {
            setState(new DispensingState());
        } else {
            System.out.println("Payment failed.");
        }
    }

    public void selectProduct(Product p) {
        currentState.selectProduct(this, p);
    }

    public void insertMoney(double amount) {
        currentState.insertMoney(this, amount);
    }

    public void dispense() {
        currentState.dispense(this);
    }

    public InventoryManager getInventory() {
        return inventory;
    }

    public void setSelectedProduct(Product p) {
        this.selectedProduct = p;
    }

    public Product getSelectedProduct() {
        return selectedProduct;
    }

    public void clearSelection() {
        this.selectedProduct = null;
    }

    public void addBalance(double amount) {
        this.currentBalance += amount;
    }

    public double getCurrentBalance() {
        return currentBalance;
    }

    public void resetBalance() {
        this.currentBalance = 0;
    }
}
