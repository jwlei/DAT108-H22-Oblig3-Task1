package task1.model;

import java.util.ArrayList;

public class ShoppingList {
    private ArrayList<Item> items = new ArrayList<Item>();

    public ArrayList<Item> getItems() {
        return items;
    }

    public void addItem(Item item) {
        /**
         * Checks if the item is already in the list, if it is, it will not be added.
         */

        if (items.contains(item)) {
            int foundAtIndex = items.indexOf(item);
            items.get(foundAtIndex).setName(item.getName());

        } else {
            items.add(item);
        }
    }

    public int getItem(Item item) {
        return items.indexOf(item);
    }

    public ShoppingList() {
    }

}
