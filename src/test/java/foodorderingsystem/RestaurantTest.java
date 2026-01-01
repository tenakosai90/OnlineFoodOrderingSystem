package foodorderingsystem;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class RestaurantTest {

    @Test
    void addMenuItem_shouldIncreaseMenuSize() {
        Restaurant r = new Restaurant(1, "MyRestaurant");
        r.addMenuItem(new MenuItem("Pizza", 50));

        assertEquals(1, r.getMenu().size());
    }

    @Test
    void removeMenuItem_shouldDecreaseMenuSize() {
        Restaurant r = new Restaurant(1, "MyRestaurant");
        MenuItem pizza = new MenuItem("Pizza", 50);

        r.addMenuItem(pizza);
        r.removeMenuItem(pizza);

        assertEquals(0, r.getMenu().size());
    }

    @Test
    void getMenu_shouldReturnList() {
        Restaurant r = new Restaurant(1, "MyRestaurant");
        List<MenuItem> menu = r.getMenu();

        assertNotNull(menu);
    }
}