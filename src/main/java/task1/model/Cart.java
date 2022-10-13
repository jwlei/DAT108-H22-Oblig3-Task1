package task1.model;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<Item> items = new ArrayList<Item>();

    public List<Item> getItems() {
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

    public void removeItem(Item item) {
        items.remove(item);
    }

    public int getItem(Item item) {
        return items.indexOf(item);
    }

    public Cart() {
    }

}
