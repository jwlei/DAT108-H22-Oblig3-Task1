package task1.model;

import java.util.ArrayList;

public class ShoppingList {
    private ArrayList<Item> items = new ArrayList<Item>();

    public ArrayList<Item> getItems() {
        return items;
    }

    public int getItem(Item item) {
        return items.indexOf(item);
    }

    public ShoppingList() {
    }

}
