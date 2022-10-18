package task1.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Objects;


public class Item {

    @NotBlank
    @Size(min = 2, max = 20, message = "{app.message.itemNameSize}")
    private String name;


    /**
     * Constructor
     * @param name
     */
    public Item(String name) {
        this.name = name;
    }


    /**
     * Checks if the name of the item is equal to the name of the other item.
     * Overrides the equals method from the Object class.
     * @param object
     * @return boolean
     */
    @Override
    public boolean equals(Object object) {

        if (this == object) {
            return false;
        }
        if (object == null) {
            return false;
        }
        if (getClass() != object.getClass()) {
            return false;
        }
        Item other = (Item) object;
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
