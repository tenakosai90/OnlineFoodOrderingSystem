package foodorderingsystem;

public class Customer extends User {

    private String address;

    public Customer(String name, String phoneNumber, String address) {
        super(name, phoneNumber);
        this.address = address;
    }

    public String getAddress() {
        return address;
    }
}