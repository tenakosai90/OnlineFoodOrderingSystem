package foodorderingsystem;

import java.util.Scanner;

public class FoodOrderingSystem {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Online Food Ordering System (Interactive) ===");

        // Create restaurant
        Restaurant restaurant = new Restaurant("SmartFood");

        // Pre-fill some items (optional, you can remove these if you want)
        restaurant.addMenuItem(new MenuItem("Pizza", 300));
        restaurant.addMenuItem(new MenuItem("Burger", 180));
        restaurant.addMenuItem(new MenuItem("Pasta", 200));

        while (true) {
            System.out.println("\nChoose user type:");
            System.out.println("1) Customer");
            System.out.println("2) Restaurant Owner/Manager");
            System.out.println("0) Exit");
            System.out.print("Your choice: ");

            int choice = readInt(sc);

            if (choice == 0) {
                System.out.println("Goodbye!");
                break;
            } else if (choice == 1) {
                customerFlow(sc, restaurant);
            } else if (choice == 2) {
                ownerFlow(sc, restaurant);
            } else {
                System.out.println("Invalid choice.");
            }
        }

        sc.close();
    }

    // ---------------- CUSTOMER FLOW ----------------
    private static void customerFlow(Scanner sc, Restaurant restaurant) {
        System.out.println("\n--- Customer Mode ---");
        System.out.print("Enter your name: ");
        String name = sc.nextLine().trim();

        System.out.print("Enter your phone number: ");
        String phone = sc.nextLine().trim();

        System.out.print("Enter your address: ");
        String address = sc.nextLine().trim();

        Customer customer = new Customer(name, phone, address);
        Order order = new Order(customer);

        while (true) {
            System.out.println("\nCustomer Menu:");
            System.out.println("1) View Restaurant Menu");
            System.out.println("2) Add Item to Order (by number)");
            System.out.println("3) View Order Summary");
            System.out.println("4) Checkout & Pay");
            System.out.println("0) Back");
            System.out.print("Your choice: ");

            int c = readInt(sc);

            if (c == 0) return;

            switch (c) {
                case 1:
                    restaurant.showMenu();
                    break;

                case 2:
                    if (restaurant.getMenuSize() == 0) {
                        System.out.println("Menu is empty. Ask the owner to add items.");
                        break;
                    }
                    restaurant.showMenu();
                    System.out.print("Enter item number to add: ");
                    int itemNo = readInt(sc);

                    if (itemNo < 1 || itemNo > restaurant.getMenuSize()) {
                        System.out.println("Invalid item number.");
                        break;
                    }

                    MenuItem selected = restaurant.getMenu().get(itemNo - 1);
                    order.addItem(selected);
                    System.out.println("Added to order: " + selected);
                    break;

                case 3:
                    order.showSummary();
                    break;

                case 4:
                    if (order.getTotalPrice() <= 0) {
                        System.out.println("Your order is empty. Add items first.");
                        break;
                    }
                    doPayment(sc, order);
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    // ---------------- OWNER FLOW ----------------
    private static void ownerFlow(Scanner sc, Restaurant restaurant) {
        System.out.println("\n--- Owner/Manager Mode ---");

        while (true) {
            System.out.println("\nOwner Menu Management:");
            System.out.println("1) View Menu");
            System.out.println("2) Add Menu Item");
            System.out.println("3) Update Menu Item (by number)");
            System.out.println("4) Remove Menu Item (by number)");
            System.out.println("0) Back");
            System.out.print("Your choice: ");

            int c = readInt(sc);

            if (c == 0) return;

            switch (c) {
                case 1:
                    restaurant.showMenu();
                    break;

                case 2:
                    System.out.print("Enter new item name: ");
                    String name = sc.nextLine().trim();
                    System.out.print("Enter price: ");
                    double price = readDouble(sc);

                    try {
                        restaurant.addMenuItem(new MenuItem(name, price));
                        System.out.println("Item added.");
                    } catch (IllegalArgumentException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 3:
                    if (restaurant.getMenuSize() == 0) {
                        System.out.println("Menu is empty.");
                        break;
                    }
                    restaurant.showMenu();
                    System.out.print("Enter item number to update: ");
                    int updateNo = readInt(sc);

                    System.out.print("Enter new name: ");
                    String newName = sc.nextLine().trim();

                    System.out.print("Enter new price: ");
                    double newPrice = readDouble(sc);

                    try {
                        boolean ok = restaurant.updateMenuItemByNumber(updateNo, newName, newPrice);
                        System.out.println(ok ? "Item updated." : "Invalid item number.");
                    } catch (IllegalArgumentException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 4:
                    if (restaurant.getMenuSize() == 0) {
                        System.out.println("Menu is empty.");
                        break;
                    }
                    restaurant.showMenu();
                    System.out.print("Enter item number to remove: ");
                    int removeNo = readInt(sc);

                    boolean removed = restaurant.removeMenuItemByNumber(removeNo);
                    System.out.println(removed ? "Item removed." : "Invalid item number.");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    // ---------------- PAYMENT ----------------
    private static void doPayment(Scanner sc, Order order) {
        System.out.println("\n--- Checkout ---");
        order.showSummary();

        System.out.println("\nChoose payment method:");
        System.out.println("1) Cash");
        System.out.println("2) Card");
        System.out.print("Your choice: ");

        int p = readInt(sc);

        PaymentMethod payment;
        if (p == 1) {
            payment = new CashPayment();
        } else if (p == 2) {
            System.out.print("Enter card number: ");
            String cardNumber = sc.nextLine().trim();

            // ✅ FIX: CardPayment requires String
            payment = new CardPayment(cardNumber);
        } else {
            System.out.println("Invalid payment choice. Cancelled.");
            return;
        }

        boolean success = order.processPayment(payment);

        System.out.println("\n=== PAYMENT RESULT ===");
        if (success) {
            System.out.println("Payment successful. Order confirmed!");
        } else {
            System.out.println("Payment failed. Try again.");
        }
    }

    // ---------------- SAFE INPUT HELPERS ----------------
    private static int readInt(Scanner sc) {
        while (true) {
            String s = sc.nextLine().trim();
            try {
                return Integer.parseInt(s);
            } catch (NumberFormatException e) {
                System.out.print("Please enter a valid integer: ");
            }
        }
    }

    private static double readDouble(Scanner sc) {
        while (true) {
            String s = sc.nextLine().trim();
            try {
                return Double.parseDouble(s);
            } catch (NumberFormatException e) {
                System.out.print("Please enter a valid number: ");
            }
        }
    }
}
