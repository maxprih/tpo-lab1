package task3;

/**
 * @author max_pri
 */
public class Human {
    private final String name;
    private final OriginPlace originPlace;
    private ConfidenceLevel confidence;
    private int confidenceInt;

    public Human(String name, OriginPlace originPlace) {
        this.name = name;
        this.originPlace = originPlace;
        confidenceInt = 0;
        confidence = ConfidenceLevel.LOW;
    }

    public ConfidenceLevel getConfidenceForEnvironment(Environment environment) {
        confidenceInt = 0;
        for (Item item : environment.getSurrounding()) {
            if (findsComfortIn(item)) {
                confidenceInt++;
            }
        }
        confidence = ConfidenceLevel.getConfidenceLevelFromInt(confidenceInt);
        return confidence;
    }

    public String getName() {
        return name;
    }

    public OriginPlace getBirthPlace() {
        return originPlace;
    }

    public ConfidenceLevel getConfidence() {
        return confidence;
    }

    private boolean findsComfortIn(Item item) {
        return this.originPlace == item.getOriginPlace();
    }
}
