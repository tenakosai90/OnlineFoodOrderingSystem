package foodorderingsystem;
/*Inheritance */
import java.util.ArrayList;
import java.util.List;

public class Customer extends User{

    private String address;
    private List<MenuItem> cart = new ArrayList<>();

    public Customer(String name, String phone, String address){
        super(name, phone); // calls User constructor
        this.address = address;
    }

    public void addToCart(MenuItem item){
        cart.add(item);
    }
    
    public List<MenuItem> getCart(){
        return cart;
    }

    public String getAddress(){
        return address;
    }
}
