package com.devops.praticedevop.service.impl;

import com.devops.praticedevop.service.CalculatorService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.regex.Pattern;

@Service
public class CalculatorServiceImpl implements CalculatorService {

    @Override
    public double sum(double a, double b) {
        return a + b;
    }

    @Override
    public double subtract(double a, double b) {
        return a - b;
    }

    @Override
    public double multiOperation(String expression) {
        return 0;
    }

    public String[] multiOperation_(String expression) {
        String matchSymbol = "+-/*x%^";
        System.out.println(Arrays.toString(expression.split("")));
        for (String f : expression.split("")) {
            System.out.println(f);
        }
//        return expression.split("");
        return expression.split("[+-/*x%^]");
    }


}
