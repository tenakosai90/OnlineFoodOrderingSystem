package foodorderingsystem;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a restaurant in the Online Food Ordering System.
 * A restaurant has an identifier, a name, and a menu consisting
 * of multiple menu items. It provides functionality to manage
 * the restaurant menu.
 */
public class Restaurant {

    private int id;
    private String name;
    private List<MenuItem> menu;

    /**
     * Creates a restaurant with the given id and name.
     * This constructor is required for unit tests.
     *
     * @param id   the unique identifier of the restaurant
     * @param name the name of the restaurant
     */
    public Restaurant(int id, String name) {
        this.id = id;
        this.name = name;
        this.menu = new ArrayList<>();
    }

    /**
     * Creates a restaurant with the given name.
     * This constructor is provided for demo convenience.
     *
     * @param name the name of the restaurant
     */
    public Restaurant(String name) {
        this(0, name);
    }

    /**
     * Returns the restaurant id.
     *
     * @return restaurant id
     */
    public int getId() {
        return id;
    }

    /**
     * Returns the restaurant name.
     *
     * @return restaurant name
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the list of menu items of the restaurant.
     *
     * @return list of MenuItem objects
     */
    public List<MenuItem> getMenu() {
        return menu;
    }

    /**
     * Adds a menu item to the restaurant menu.
     *
     * @param item the MenuItem to add
     */
    public void addMenuItem(MenuItem item) {
        menu.add(item);
    }

    /**
     * Removes a menu item from the restaurant menu.
     * This method is required for unit tests.
     *
     * @param item the MenuItem to remove
     */
    public void removeMenuItem(MenuItem item) {
        menu.remove(item);
    }

    /**
     * Displays the restaurant menu on the console.
     */
    public void showMenu() {
        System.out.println("Menu for " + name + ":");
        for (MenuItem item : menu) {
            System.out.println(item);
        }
    }
}
