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
    
}