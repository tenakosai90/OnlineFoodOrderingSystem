package foodorderingsystem;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MenuItemTest {

    @Test
    void constructor_shouldCreateMenuItem_whenPriceIsValid() {
        MenuItem item = new MenuItem("Pizza", 50);
        assertEquals("Pizza", item.getName());
        assertEquals(50, item.getPrice());
    }

    @Test
    void constructor_shouldThrowException_whenPriceIsNegative() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new MenuItem("Burger", -1)
        );
    }
}
