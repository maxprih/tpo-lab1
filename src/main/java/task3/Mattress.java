package task3;

/**
 * @author max_pri
 */
public class Mattress extends Item {
    private final int size;

    public Mattress(String name, OriginPlace originPlace, int size) {
        super(name, originPlace);
        this.size = size;
    }

    public int getSize() {
        return size;
    }
}
