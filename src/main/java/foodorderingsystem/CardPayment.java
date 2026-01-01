package foodorderingsystem;

public class CardPayment implements PaymentMethod {

    private final String cardNumber;

    public CardPayment(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public boolean pay(double amount) {
        // Simple validation for tests
        return amount >= 0 && cardNumber != null && !cardNumber.trim().isEmpty();
    }
}