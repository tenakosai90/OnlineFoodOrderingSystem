package foodorderingsystem;

import java.util.List;

public class FoodOrderingSystem {

    public static void main(String[] args) {

        System.out.println(">> Creating customer...");
        Customer customer = new Customer(
                "Issa",
                "05550000000",
                "Istanbul"
        );

        System.out.println("\n>> Creating restaurant...");
        Restaurant restaurant = new Restaurant(1, "SmartFood");

        // --- Owner adds menu items ---
        restaurant.addMenuItem(new MenuItem("Pizza", 300));
        restaurant.addMenuItem(new MenuItem("Burger", 180));
        restaurant.addMenuItem(new MenuItem("Pasta", 200));

        // --- Show menu (NUMBERED) ---
        System.out.println("\n>> Menu:");
        showNumberedMenu(restaurant);

        // --- Owner updates menu item (by number) ---
        System.out.println("\n>> Updating menu item #2 (Burger -> Cheeseburger)");
        restaurant.updateMenuItemByNumber(2, "Cheeseburger", 220);

        // --- Owner removes menu item (by number) ---
        System.out.println("\n>> Removing menu item #3");
        restaurant.removeMenuItemByNumber(3);

        // --- Show updated menu ---
        System.out.println("\n>> Updated Menu:");
        showNumberedMenu(restaurant);

        // --- Customer places order ---
        System.out.println("\n>> Placing order...");
        Order order = new Order(customer);

        // Customer selects items by number
        order.addItem(restaurant.getMenu().get(0)); // Pizza
        order.addItem(restaurant.getMenu().get(1)); // Cheeseburger

        // --- Show order summary ---
        System.out.println("\n>> Order summary:");
        order.showSummary();

        // --- Payment ---
        System.out.println("\n>> Processing payment...");
        PaymentMethod payment = new CashPayment();
        boolean success = order.processPayment(payment);

        System.out.println("\n=== PAYMENT RESULT ===");
        if (success) {
            System.out.println("Payment successful. Order confirmed!");
        } else {
            System.out.println("Payment failed.");
        }

        System.out.println("\nThank you for using SmartFood!");
    }

    // ================= HELPER METHOD =================
    private static void showNumberedMenu(Restaurant restaurant) {
        List<MenuItem> menu = restaurant.getMenu();
        System.out.println("Menu for " + restaurant.getName() + ":");
        for (int i = 0; i < menu.size(); i++) {
            System.out.println((i + 1) + ". " + menu.get(i));
        }
    }
}
