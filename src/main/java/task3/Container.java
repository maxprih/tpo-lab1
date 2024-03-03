package task3;

/**
 * @author max_pri
 */
public class Container<T> {
    private T item;
    private final ContainerShape shape;
    private final String material;

    public Container(ContainerShape shape, String material) {
        this.shape = shape;
        this.material = material;
    }

    public T getItem() {
        if (item == null) {
            throw new ContainerIsEmptyException("В контейнере нет предмета");
        }
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }

    public ContainerShape getShape() {
        return shape;
    }

    public String getMaterial() {
        return material;
    }
}
