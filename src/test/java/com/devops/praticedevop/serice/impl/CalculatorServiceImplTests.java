package com.devops.praticedevop.serice.impl;

import static org.junit.jupiter.api.Assertions.*;

import com.devops.praticedevop.service.impl.CalculatorServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CalculatorServiceImplTests {

    private final CalculatorServiceImpl calculatorService = new CalculatorServiceImpl();

    @Test
    public void testSum(){
        double sum = 3;
        assertEquals(sum, calculatorService.sum(1, 2));
    }

    @Test
    public void testSubtract(){
        double sum = 0;
        assertEquals(sum, calculatorService.subtract(2, 2));
    }

    @Test
    public void testMultiOperation() {
        double expected = 108;

        assertEquals(expected, calculatorService.multiOperation("100-5+13"));
    }

    @Test
    public void testExpressionSplit() {
        String[] expected = {"100", "+", "5", "+", "7"};
        assertArrayEquals(expected, calculatorService.expressionSplit("100+5+7"));

        expected = new String[]{"100.55", "+", "0.5", "+", "7"};
        assertArrayEquals(expected, calculatorService.expressionSplit("100.55+0.5+7"));
    }
}
