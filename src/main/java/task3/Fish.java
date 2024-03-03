package task3;

/**
 * @author max_pri
 */
public class Fish {
    private final String name;
    private final Size size;
    private final String color;

    public Fish(String name, Size size, String color) {
        this.name = name;
        this.size = size;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public Size getSize() {
        return size;
    }

    public String getColor() {
        return color;
    }
}
