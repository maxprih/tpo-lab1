package task3;

/**
 * @author max_pri
 */
public enum ConfidenceLevel {
    LOW,
    MEDIUM,
    HIGH,
    LARGE;

    public static ConfidenceLevel getConfidenceLevelFromInt(int confidence) {
        if (confidence >= 3) {
            return LARGE;
        } else if (confidence == 2) {
            return HIGH;
        } else if (confidence == 1) {
            return MEDIUM;
        } else return LOW;
    }
}
