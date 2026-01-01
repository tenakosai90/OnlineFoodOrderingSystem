package foodorderingsystem;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {

    private int id;
    private String name;
    private final List<MenuItem> menu = new ArrayList<>();

    // ✅ Needed because my tests use (1, "MyRestaurant")
    public Restaurant(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // ✅ Keep the original style too (optional)
    public Restaurant(String name) {
        this.name = name;
        this.id = 0;
    }

    public void addMenuItem(MenuItem item) {
        menu.add(item);
    }

    // ✅ Needed by tests
    public void removeMenuItem(MenuItem item) {
        menu.remove(item);
    }

    public List<MenuItem> getMenu() {
        return menu;
    }

    public void showMenu() {
        System.out.println("=== " + name + " MENU ===");
        for (int i = 0; i < menu.size(); i++) {
            System.out.println((i + 1) + " - " + menu.get(i).getInfo());
        }
    }
}