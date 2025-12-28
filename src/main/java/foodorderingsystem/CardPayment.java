package foodorderingsystem;
/*Polymorphism */
public class CardPayment implements PaymentMethod{

    @Override
    public String pay(double amount){
        return "Paid " + amount + " TL with credit card.";
    }
    
}
