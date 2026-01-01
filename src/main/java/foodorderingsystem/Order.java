package foodorderingsystem;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private Customer customer;
    private final List<MenuItem> items = new ArrayList<>();

    // ✅ Needed because my tests do: new Order()
    public Order() {
        this.customer = null; // allowed for tests
    }

    // ✅ Your original constructor (keep it)
    public Order(Customer customer) {
        this.customer = customer;
    }

    public void addItem(MenuItem item) {
        items.add(item);
    }

    public double calculateTotal() {
        double total = 0;
        for (MenuItem item : items) {
            total += item.getPrice();
        }
        return total;
    }

    // ✅ Needed because tests call getTotalPrice()
    public double getTotalPrice() {
        return calculateTotal();
    }

    public void showSummary() {
        System.out.println("=== ORDER SUMMARY ===");
        if (customer != null) {
            System.out.println("Customer: " + customer.getName());
            System.out.println("Address: " + customer.getAddress());
        }
        for (MenuItem item : items) {
            System.out.println("- " + item.getInfo());
        }
        System.out.println("Total: " + calculateTotal() + " TL");
    }

    // ✅ Now returns boolean (because PaymentMethod.pay returns boolean)
    public boolean processPayment(PaymentMethod method) {
        return method.pay(calculateTotal());
    }
}