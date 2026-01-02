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

    public void addMenuItem(MenuItem item) {
        menu.add(item);
    }

    // REQUIRED by tests
    public void removeMenuItem(MenuItem item) {
        menu.remove(item);
    }

    public void showMenu() {
        System.out.println("Menu for " + name + ":");
        for (MenuItem item : menu) {
            System.out.println(item);
        }
    }
}