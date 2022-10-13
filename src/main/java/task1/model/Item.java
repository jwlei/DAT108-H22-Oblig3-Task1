package task1.model;

import java.util.Objects;


public class Item {
    private String name;


    /**
     * Constructor
     * @param name
     */
    public Item(String name) {
        this.name = name;
    }


    @Override
    public boolean equals(Object obj) {
        /**
         * Checks if the name of the item is equal to the name of the other item.
         */
        if (this == obj) {
            return false;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Item other = (Item) obj;
        return Objects.equals(name, other.name);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "ITEM [" + name + "]";
    }
}
