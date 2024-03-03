package task3;

/**
 * @author max_pri
 */
public class Underwear extends Item {
    private final int size;

    public Underwear(String name, OriginPlace originPlace, int size) {
        super(name, originPlace);
        this.size = size;
    }

    public int getSize() {
        return size;
    }
}
