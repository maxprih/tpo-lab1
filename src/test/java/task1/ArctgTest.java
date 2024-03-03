package task1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ArctanTests {

    @Test
    void testArctanWithZero() {
        double result = Math.atan(0);
        assertEquals(0, result, 0.0001, "arctan(0) should be 0");
    }

    @Test
    void testArctanWithPositiveValue() {
        double result = Math.atan(1);
        assertEquals(Math.PI / 4, result, 0.0001, "arctan(1) should be π/4");
    }

    @Test
    void testArctanWithNegativeValue() {
        double result = Math.atan(-1);
        assertEquals(-Math.PI / 4, result, 0.0001, "arctan(-1) should be -π/4");
    }

    @Test
    void testArctanWithInfinity() {
        double result = Math.atan(Double.POSITIVE_INFINITY);
        assertEquals(Math.PI / 2, result, 0.0001, "arctan(∞) should be π/2");
    }

    @Test
    void testArctanWithNegativeInfinity() {
        double result = Math.atan(Double.NEGATIVE_INFINITY);
        assertEquals(-Math.PI / 2, result, 0.0001, "arctan(-∞) should be -π/2");
    }

    @Test
    void testArctanWithNaN() {
        double result = Math.atan(Double.NaN);
        assertTrue(Double.isNaN(result), "arctan(NaN) should be NaN");
    }

}