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
     * Removes a menu item using its displayed number (1-based index).
     * Useful for restaurant owners when managing the menu.
     *
     * @param number the menu item number shown to the user
     * @return true if removal was successful, false otherwise
     */
    public boolean removeMenuItemByNumber(int number) {
        if (number < 1 || number > menu.size()) {
            return false;
        }
        menu.remove(number - 1);
        return true;
    }

    /**
     * Displays the restaurant menu with numbered items.
     */
    public void showMenu() {
        System.out.println("Menu for " + name + ":");

        if (menu.isEmpty()) {
            System.out.println("No items available.");
            return;
        }

        for (int i = 0; i < menu.size(); i++) {
            System.out.println((i + 1) + ". " + menu.get(i).getInfo());
        }
    }
}
