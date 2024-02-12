package com.devops.praticedevop.service.impl;

import com.devops.praticedevop.service.CalculatorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

@Service
public class CalculatorServiceImpl implements CalculatorService {

    private static final Logger logger = LoggerFactory.getLogger(CalculatorService.class);

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
        String matchSymbol = "+-/*x%^";
        String[] expressions = this.expressionSplit(expression);

        logger.info("Expression to operate on is: " + Arrays.toString(expressions));
        if (!expressions[0].matches("[0-9+-.]+")) {
            return Double.NaN;
        }

        double total = 0;
        String nextOperation = "+";

        for (String s : expressions) {
            if (!s.matches("[0-9.]+")) {
                nextOperation = s;
            } else {
                total = this.operation(total, nextOperation, s);
            }
        }

        return total;
    }

    /**
     * Perform Basic calcul
     *
     * @param total Current total
     * @param operation The operation to do
     * @param value The value to operate on total
     * @return double
     */
    public double operation(double total, String operation, String value) {
        double val = Double.parseDouble(value);

        return switch (operation) {
            case "-" -> total - val;
            case "+" -> total + val;
            default -> 0;
        };
    }

    public String[] expressionSplit(String expression) {
        String matchSymbol = "[+-/*x%^]";
        ArrayList<String> expressions = new ArrayList<>();

        StringBuilder tmp = new StringBuilder();
        String[] expressionArray = expression.split("");

        for (int i = 0; i < expressionArray.length; i++) {
            if (!Objects.equals(expressionArray[i], ".")) {
                if (expressionArray[i].matches(matchSymbol)) {
                    if (tmp.length() > 0) {
                        expressions.add(tmp.toString());
                        tmp = new StringBuilder();
                    }
                    expressions.add(expressionArray[i]);
                } else {
                    tmp.append(expressionArray[i]);
                    if (i == expressionArray.length-1) {
                        expressions.add(tmp.toString());
                    }
                }
            } else {
                tmp.append(expressionArray[i]);
            }
        }
        System.out.println("expression list : " + expressions);

        return expressions.toArray(new String[0]);
    }

}
