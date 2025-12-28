package foodorderingsystem;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private Customer customer;
    private List<MenuItem> items = new ArrayList<>();

    public Order(Customer customer){
        this.customer = customer;
    }

    public void addItem(MenuItem item){
        items.add(item);
    }

    public double calculateTotal(){
        double total = 0;
        for (MenuItem item : items){
            total += item.getPrice();
        }
        return total;
    }

    public void showSummary(){
        System.out.println("=== ORDER SUMMARY ===");
        System.out.println("Customer: " + customer.getName());
        System.out.println("Address: " + customer.getAddress());

        for (MenuItem item : items){
            System.out.println(" - " + item.getInfo());
        }

        System.out.println("Total: " + calculateTotal() + " TL ");

        }
    
    public String processPayment(PaymentMethod method){
            return method.pay(calculateTotal());


    }
    
}
