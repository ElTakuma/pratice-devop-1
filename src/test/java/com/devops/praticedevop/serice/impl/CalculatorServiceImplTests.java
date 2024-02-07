package com.devops.praticedevop.serice.impl;

import static org.junit.jupiter.api.Assertions.*;

import com.devops.praticedevop.service.CalculatorService;
import com.devops.praticedevop.service.impl.CalculatorServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
public class CalculatorServiceImplTests {

    private final CalculatorService calculatorService = new CalculatorServiceImpl();

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
}
