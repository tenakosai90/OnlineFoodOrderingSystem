package foodorderingsystem;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class OrderTest {

    @Test
    void addItem_shouldIncreaseTotalPrice() {
        Order order = new Order();
        MenuItem pizza = new MenuItem("Pizza", 50.0);

        order.addItem(pizza);

        assertEquals(50.0, order.getTotalPrice(),
                "Total price should be 50 after adding one item");
    }

    @Test
    void addMultipleItems_shouldSumPricesCorrectly() {
        Order order = new Order();
        order.addItem(new MenuItem("Pizza", 50.0));
        order.addItem(new MenuItem("Burger", 30.0));

        assertEquals(80.0, order.getTotalPrice());
    }
}