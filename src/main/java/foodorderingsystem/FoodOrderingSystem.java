package foodorderingsystem;

public class FoodOrderingSystem {

    public static void main(String[] args) {

        System.out.println("=== ONLINE FOOD ORDERING SYSTEM ===\n");

        System.out.println(">> Creating restaurant and menu...");
        Restaurant restaurant = new Restaurant("SmartFood");
        restaurant.addMenuItem(new MenuItem("Pizza", 300));
        restaurant.addMenuItem(new MenuItem("Burger", 180));
        restaurant.addMenuItem(new MenuItem("Pasta", 200));

        System.out.println("\n>> Creating customer...");
        Customer customer = new Customer("Issa", "555-0102", "Istanbul");

        System.out.println("\n>> Placing order...");
        Order order = new Order(customer);
        order.addItem(restaurant.getMenu().get(0));
        order.addItem(restaurant.getMenu().get(2));

        System.out.println("\n>> Menu:");
        restaurant.showMenu();

        System.out.println("\n>> Order summary:");
        order.showSummary();

        System.out.println("\n>> Processing payment...");
        PaymentMethod payment = new CashPayment();

        boolean success = order.processPayment(payment);

        System.out.println("\n=== PAYMENT RESULT ===");
        if (success) {
            System.out.println("Payment successful. Order confirmed!");
        } else {
            System.out.println("Payment failed. Please try again.");
        }

        System.out.println("\nThank you for using SmartFood!");
    }
}