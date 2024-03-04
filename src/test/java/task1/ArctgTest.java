package task1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class ArctgTest {
    double eps = 0.03;

    @ParameterizedTest
    @DisplayName("Положительные значения")
    @ValueSource(doubles = {0.2, 0.36894, 0.5, 0.634, 0.743})
    public void regularPositiveValuesTest(double value) {
        Assertions.assertEquals(Math.atan(value), Arctg.arctg(value), eps);
    }

    @ParameterizedTest
    @DisplayName("Отрицательные значения")
    @ValueSource(doubles = {-0.2, -0.36894, -0.5, -0.634, -0.743})
    public void regularNegativeValuesTest(double value) {
        Assertions.assertEquals(Math.atan(value), Arctg.arctg(value), eps);
    }

    @ParameterizedTest
    @DisplayName("Близкие к 1 положительные значения")
    @ValueSource(doubles = {0.85, 0.9, 0.95, 0.99, 0.999, 0.9999})
    public void closeToPositiveOneValuesTest(double value) {
        Assertions.assertEquals(Math.atan(value), Arctg.arctg(value), eps);
    }

    @ParameterizedTest
    @DisplayName("Близкие к -1 отрицательные значения")
    @ValueSource(doubles = {-0.85, -0.9, -0.95, -0.99, -0.999, -0.9999})
    public void closeToNegativeOneValuesTest(double value) {
        Assertions.assertEquals(Math.atan(value), Arctg.arctg(value), eps);
    }

    @ParameterizedTest
    @DisplayName("Близкие к 0 значения")
    @ValueSource(doubles = {-0.1, -0.05, -0.01, 0.01, 0.05, 0.1})
    public void closeToZeroValuesTest(double value) {
        Assertions.assertEquals(Math.atan(value), Arctg.arctg(value), eps);
    }

    @Test
    @DisplayName("Положительный ноль")
    public void positiveZeroTest() {
        Assertions.assertEquals(Math.atan(+0), Arctg.arctg(+0), eps);
    }

    @Test
    @DisplayName("Отрицательный ноль")
    public void negativeZeroTest() {
        Assertions.assertEquals(Math.atan(-0), Arctg.arctg(-0), eps);
    }

    @Test
    @DisplayName("Положительная единица")
    public void positiveOneTest() {
        Assertions.assertEquals(Math.atan(1), Arctg.arctg(1), eps * 2);
    }

    @Test
    @DisplayName("Отрицательная единица")
    public void negativeOneTest() {
        Assertions.assertEquals(Math.atan(-1), Arctg.arctg(-1), eps * 2);
    }

//    @ParameterizedTest
//    @DisplayName("Невалидные значения")
//    @ValueSource(doubles = {-500, -3, -2, -1.001, 1.001, 2, 3, 500})
//    public void invalidValuesTest(double value) {
//        Assertions.assertEquals(Math.atan(value), Arctg.arctg(value), eps);
//    }
}