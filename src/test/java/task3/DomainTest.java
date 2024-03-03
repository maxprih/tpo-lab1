package task3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author max_pri
 */
public class DomainTest {

    @Test
    @DisplayName("Уровень уверенности")
    public void testConfidenceLevel() {
        assertEquals(ConfidenceLevel.LOW, ConfidenceLevel.getConfidenceLevelFromInt(0));
        assertEquals(ConfidenceLevel.MEDIUM, ConfidenceLevel.getConfidenceLevelFromInt(1));
        assertEquals(ConfidenceLevel.HIGH, ConfidenceLevel.getConfidenceLevelFromInt(2));
        assertEquals(ConfidenceLevel.LARGE, ConfidenceLevel.getConfidenceLevelFromInt(3));
    }

    @Test
    @DisplayName("Пустое окружение")
    public void testEmptyEnvironment() {
        Environment environment = new Environment();

        assertEquals(new ArrayList<>(), environment.getSurrounding());
    }

    @Test
    @DisplayName("Добавление в окружение")
    public void testAddEnvironment() {
        Environment environment = new Environment();
        Item cereal = new Cereal("Bebra", OriginPlace.EARTH, "Corn");

        assertEquals(new ArrayList<>(), environment.getSurrounding());
        environment.addToSurrounding(cereal);

        assertTrue(environment.getSurrounding().contains(cereal));
    }

    @Test
    @DisplayName("Конструктор Fish")
    public void testFishConstructor() {
        Fish fish = new Fish("Yandexoid", Size.SMALL, "Yellow");

        assertEquals("Yandexoid", fish.getName());
        assertEquals(Size.SMALL, fish.getSize());
        assertEquals("Yellow", fish.getColor());
    }

    @Test
    @DisplayName("Конструктор Container")
    public void testContainerConstructor() {
        Container<?> container = new Container<>(ContainerShape.AQUARIUM, "Glass");

        assertEquals(ContainerShape.AQUARIUM, container.getShape());
        assertEquals("Glass", container.getMaterial());
    }

    @Test
    @DisplayName("Пустой контейнер")
    public void testEmptyContainer() {
        Container<?> container = new Container<>(ContainerShape.AQUARIUM, "Glass");

        assertThrows(ContainerIsEmptyException.class, container::getItem);
    }

    @Test
    @DisplayName("Добавление предмета в контейнер")
    public void testAddItemToContainer() {
        Container<Fish> container = new Container<>(ContainerShape.AQUARIUM, "Glass");
        Fish fish = new Fish("Yandexoid", Size.SMALL, "Yellow");

        container.setItem(fish);

        assertEquals(fish, container.getItem());
    }

    @Test
    @DisplayName("Замена предмета в контейнере")
    public void testReplaceItemToContainer() {
        Container<Fish> container = new Container<>(ContainerShape.AQUARIUM, "Glass");
        Fish fish = new Fish("Yandexoid", Size.SMALL, "Yellow");
        Fish fish2 = new Fish("Tinkoffyanin", Size.MEDIUM, "Red");

        container.setItem(fish);
        assertEquals(fish, container.getItem());

        container.setItem(fish2);
        assertNotEquals(fish, container.getItem());
        assertEquals(fish2, container.getItem());
    }

    @Test
    @DisplayName("Конструктор Item")
    public void testItemConstructor() {
        Item testItem = new Item("test item", OriginPlace.BETELGEUSE) {
        };

        assertEquals("test item", testItem.getName());
        assertEquals(OriginPlace.BETELGEUSE, testItem.getOriginPlace());
    }

    @Test
    @DisplayName("Конструктор Cereal")
    public void testCerealConstructor() {
        Cereal cereal = new Cereal("Test", OriginPlace.EARTH, "Corn");

        assertEquals("Test", cereal.getName());
        assertEquals(OriginPlace.EARTH, cereal.getOriginPlace());
        assertEquals("Corn", cereal.getType());
    }

    @Test
    @DisplayName("Конструктор Mattress")
    public void testMattressConstructor() {
        Mattress mattress = new Mattress("Test", OriginPlace.DENTRASSI, 150);

        assertEquals("Test", mattress.getName());
        assertEquals(OriginPlace.DENTRASSI, mattress.getOriginPlace());
        assertEquals(150, mattress.getSize());
    }

    @Test
    @DisplayName("Конструктор Underwear")
    public void testUnderwearConstructor() {
        Underwear underwear = new Underwear("Test", OriginPlace.SQUORNSHELL, 34);

        assertEquals("Test", underwear.getName());
        assertEquals(OriginPlace.SQUORNSHELL, underwear.getOriginPlace());
        assertEquals(34, underwear.getSize());
    }

    @Test
    @DisplayName("Конструктор Human")
    public void testHumanConstructor() {
        Human human = new Human("Test", OriginPlace.EARTH);

        assertEquals("Test", human.getName());
        assertEquals(OriginPlace.EARTH, human.getBirthPlace());
        assertEquals(ConfidenceLevel.LOW, human.getConfidence());
    }

    @Test
    @DisplayName("Уверенность человека при одинаковых происхождениях")
    public void testHumanConfidenceMatchingOrigin() {
        Human human = new Human("Test", OriginPlace.EARTH);

        Item mattress = new Mattress("123", OriginPlace.EARTH, 150);
        Item cereal = new Cereal("123", OriginPlace.EARTH, "Ovsyanka");

        Environment environment = new Environment();
        environment.addToSurrounding(mattress);
        environment.addToSurrounding(cereal);

        assertEquals(ConfidenceLevel.HIGH, human.getConfidenceForEnvironment(environment));
    }

    @Test
    @DisplayName("Уверенность человека при разных происхождениях")
    public void testHumanConfidenceNoMatchingOrigin() {
        Human human = new Human("Test", OriginPlace.BETELGEUSE);

        Item mattress = new Mattress("123", OriginPlace.EARTH, 150);
        Item cereal = new Cereal("123", OriginPlace.EARTH, "Ovsyanka");

        Environment environment = new Environment();
        environment.addToSurrounding(mattress);
        environment.addToSurrounding(cereal);

        assertEquals(ConfidenceLevel.LOW, human.getConfidenceForEnvironment(environment));
    }

    @Test
    @DisplayName("Уверенность человека при пустом окружении")
    public void testHumanConfidenceEmptyEnvironment() {
        Human human = new Human("Test", OriginPlace.BETELGEUSE);

        Environment environment = new Environment();

        assertEquals(ConfidenceLevel.LOW, human.getConfidenceForEnvironment(environment));
    }
}
