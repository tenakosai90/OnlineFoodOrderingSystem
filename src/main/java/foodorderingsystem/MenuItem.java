package foodorderingsystem;
/*Implementation */
public class MenuItem implements Orderable {

    private String itemName;
    private double itemPrice;

    public MenuItem(String itemName, double itemPrice){
        this.itemName = itemName;
        this.itemPrice = itemPrice;
    }

    @Override
    public double getPrice(){
        return itemPrice;
    }

    @Override
    public String getInfo(){
        return itemName + " - " + itemPrice + "TL";
    }
    if (price < 0) {
    throw new IllegalArgumentException("Price cannot be negative");
}
    
}
