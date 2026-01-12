package foodorderingsystem;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {

    private int id;
    private String name;
    private List<MenuItem> menu;

    // REQUIRED by tests
    public Restaurant(int id, String name) {
        this.id = id;
        this.name = name;
        this.menu = new ArrayList<>();
    }

    // Optional (demo convenience)
    public Restaurant(String name) {
        this(0, name);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<MenuItem> getMenu() {
        return menu;
    }

    public int getMenuSize() {
        return menu.size();
    }

    public void addMenuItem(MenuItem item) {
        menu.add(item);
    }

    // REQUIRED by tests
    public void removeMenuItem(MenuItem item) {
        menu.remove(item);
    }

    // ✅ Remove by displayed number (1..n)
    public boolean removeMenuItemByNumber(int number) {
        int index = number - 1;
        if (index < 0 || index >= menu.size()) return false;
        menu.remove(index);
        return true;
    }

    // ✅ Update by displayed number (1..n)
    // MenuItem has no setters, so we replace the object
    public boolean updateMenuItemByNumber(int number, String newName, double newPrice) {
        int index = number - 1;
        if (index < 0 || index >= menu.size()) return false;
        menu.set(index, new MenuItem(newName, newPrice));
        return true;
    }

    // ✅ Numbered menu display: 1,2,3...
    public void showMenu() {
        System.out.println("Menu for " + name + ":");
        if (menu.isEmpty()) {
            System.out.println("(empty)");
            return;
        }
        for (int i = 0; i < menu.size(); i++) {
            System.out.println((i + 1) + ". " + menu.get(i));
        }
    }
}
