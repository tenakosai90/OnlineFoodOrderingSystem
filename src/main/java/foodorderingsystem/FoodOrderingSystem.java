package foodorderingsystem;

public class FoodOrderingSystem {

    public static void main(String[] args) {

        // Create restaurant
        Restaurant restaurant = new Restaurant(1, "SmartFood");
        restaurant.addMenuItem(new MenuItem("Pizza", 300));
        restaurant.addMenuItem(new MenuItem("Burger", 180));
        restaurant.addMenuItem(new MenuItem("Pasta", 200));

        // Create customer
        Customer customer = new Customer("Issa", "555-0102", "Istanbul");

        // Create order
        Order order = new Order(customer);
        order.addItem(restaurant.getMenu().get(0)); // Pizza
        order.addItem(restaurant.getMenu().get(2)); // Pasta

        // Show menu and order
        restaurant.showMenu();
        System.out.println();
        order.showSummary();
        System.out.println();

        // Payment
        PaymentMethod payment = new CashPayment();
        boolean success = order.processPayment(payment);

        System.out.println("Payment success: " + success);
    }
}