package foodorderingsystem;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a customer's order in the Online Food Ordering System.
 * An order contains selected menu items, can calculate the total price,
 * display a summary, and process payment using a payment method.
 */
public class Order {

    private Customer customer;
    private final List<MenuItem> items = new ArrayList<>();

    /**
     * Creates an empty order.
     * This constructor is required for unit tests that use new Order().
     */
    public Order() {
        this.customer = null; // allowed for tests
    }

    /**
     * Creates an order associated with a specific customer.
     *
     * @param customer the customer who placed the order
     */
    public Order(Customer customer) {
        this.customer = customer;
    }

    /**
     * Adds a menu item to the order.
     *
     * @param item the MenuItem to add
     */
    public void addItem(MenuItem item) {
        items.add(item);
    }

    /**
     * Calculates the total price of all menu items in the order.
     *
     * @return total price of the order
     */
    public double calculateTotal() {
        double total = 0;
        for (MenuItem item : items) {
            total += item.getPrice();
        }
        return total;
    }

    /**
     * Returns the total price of the order.
     * This method exists to satisfy unit test expectations.
     *
     * @return total price of the order
     */
    public double getTotalPrice() {
        return calculateTotal();
    }

    /**
     * Displays a summary of the order, including customer information,
     * ordered items, and total price.
     */
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

    /**
     * Processes payment for the order using the given payment method.
     *
     * @param method the payment method to use
     * @return true if payment is successful, false otherwise
     */
    public boolean processPayment(PaymentMethod method) {
        return method.pay(calculateTotal());
    }
}
