package ch.zhaw.iwi.devops.stringcalculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class StringCalculatorTest {
    @Test
    public void testLeererString() {
        StringCalculator calculator = new StringCalculator();
        int result = calculator.add("");
        Assertions.assertEquals(0, result);
    }
    @Test
    public void testEinzelZahlen() {
        StringCalculator calculator = new StringCalculator();
        int result = calculator.add("5");
        Assertions.assertEquals(5, result);
    }
    @Test
    public void testZweiZahlen() {
        StringCalculator calculator = new StringCalculator();
        int result = calculator.add("2,3");
        Assertions.assertEquals(5, result);
    }
    @Test
    public void testMehrereZahlen() {
        StringCalculator calculator = new StringCalculator();
        int result = calculator.add("1,2,3,4,5");
        Assertions.assertEquals(15, result);
    }
    @Test
    public void testZahlenMitUmbruch() {
        StringCalculator calculator = new StringCalculator();
        int result = calculator.add("1\n2,3");
        Assertions.assertEquals(6, result);
    }
    @Test
    public void testZahlenMitSpezTrennZ() {
        StringCalculator calculator = new StringCalculator();
        int result = calculator.add("//;\n1;2;3");
        Assertions.assertEquals(6, result);
    }
    @Test
    public void testNegativeZahlen() {
        StringCalculator calculator = new StringCalculator();
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            calculator.add("1,-2,3,-4");
        });
        String expectedMessage = "Negatives not allowed: -2 -4 ";
        String actualMessage = exception.getMessage();
        Assertions.assertEquals(expectedMessage, actualMessage);
    }
    @Test
    public void testZahlenGrösserAls1000Ignorieren() {
        StringCalculator calculator = new StringCalculator();
        int result = calculator.add("2,1001,6");
        Assertions.assertEquals(8, result);
    }
}