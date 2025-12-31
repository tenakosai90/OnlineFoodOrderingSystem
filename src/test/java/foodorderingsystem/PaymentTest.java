package foodorderingsystem;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PaymentTest {

    @Test
    void cashPayment_shouldSucceed() {
        PaymentMethod cash = new CashPayment();
        boolean result = cash.pay(50.0);

        assertTrue(result, "Cash payment should succeed");
    }

    @Test
    void cardPayment_shouldSucceed() {
        PaymentMethod card = new CardPayment("1234-5678-9012-3456");
        boolean result = card.pay(50.0);

        assertTrue(result, "Card payment should succeed");
    }
}