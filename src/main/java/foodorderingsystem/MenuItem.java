package foodorderingsystem;

public class MenuItem {

    private String name;
    private double price;

    public MenuItem(String name, double price) {
        if (price < 0) {
            throw new IllegalArgumentException("Price cannot be negative");
        }
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    // Used for clean menu display
    public String getInfo() {
        return name + " - " + price + " TL";
    }

    // 🔥 IMPORTANT FIX: makes printing readable
    @Override
    public String toString() {
        return name + " - " + price + " TL";
    }
}