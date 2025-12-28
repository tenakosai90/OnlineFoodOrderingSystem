package foodorderingsystem;
/*Polymorphism */
public class CashPayment implements PaymentMethod{

    @Override
    public String pay(double amount){
        return "Paid " + amount + " TL in cash.";
    }
    
}
