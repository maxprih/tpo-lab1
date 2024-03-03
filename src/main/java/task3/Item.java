package task3;

/**
 * @author max_pri
 */
public abstract class Item {
    private final String name;
    private final OriginPlace originPlace;

    public Item(String name, OriginPlace originPlace) {
        this.name = name;
        this.originPlace = originPlace;
    }

    public String getName() {
        return name;
    }

    public OriginPlace getOriginPlace() {
        return originPlace;
    }
}
