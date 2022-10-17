package task1.model;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<Item> items = new ArrayList<>();


    /**
     * returns the list of items in the cart
     * @return List<Item>
     */
    public List<Item> getItems() {
        return items;
    }


    /**
     * adds an item to the cart
     * @param item
     */
    public void addItem(Item item) {
        items.add(item);
    }


    /**
     * removes an item from the cart
     * @param item
     */
    public void removeItem(Item item) {
        items.remove(item);
    }


    /**
     * Empty constructor
     * Necessary for the @SessionAttributes annotation
     */
    public Cart() {
    }


    /**
     * Check if the item already exists in the cart
     * @param item
     * @return boolean
     */
    public boolean itemExists(Item item) {
        return items.contains(item);
    }


    @Override
    public String toString() {
        return "CART [" + items + "]";
    }
}
