package task3;

import java.util.ArrayList;
import java.util.List;

/**
 * @author max_pri
 */
public class Environment {
    private final List<Item> surrounding = new ArrayList<>();

    public void addToSurrounding(Item item) {
        surrounding.add(item);
    }

    public List<Item> getSurrounding() {
        return surrounding;
    }
}
