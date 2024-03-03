package task3;

/**
 * @author max_pri
 */
public class Cereal extends Item {
    private final String type;

    public Cereal(String name, OriginPlace originPlace, String type) {
        super(name, originPlace);
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
