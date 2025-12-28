package foodorderingsystem;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {

    private String name;
    private List<MenuItem> menu = new ArrayList<>();

    public Restaurant(String name){
        this.name = name;
    }

    public void addMenuItem(MenuItem item){
        menu.add(item);
    }

    public List<MenuItem> getMenu(){
        return menu;
    }

    public void showMenu(){
        System.out.println(" === " + name + " MENU ===");
        for (int i = 0; i < menu.size(); i++){
            System.out.println((i + 1) + " . " + menu.get(i).getInfo());
        }
    }
    
}
