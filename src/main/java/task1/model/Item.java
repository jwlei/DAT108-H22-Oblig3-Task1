package task1.model;

import java.util.Objects;

public class Item {
    private String name;

    public Item(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        /**
         * Used to determine if two objects are equal.
         * If two objects are equal, they must have the same hash code.
         */
        return Objects.hash(name);
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
}
