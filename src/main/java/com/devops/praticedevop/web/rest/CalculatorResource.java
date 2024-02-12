package com.devops.praticedevop.web.rest;

import com.devops.praticedevop.service.CalculatorService;
import com.devops.praticedevop.service.dto.OperationDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/calculator")
public class CalculatorResource {

    private final CalculatorService calculatorService;
    private static Logger logger = LoggerFactory.getLogger(CalculatorResource.class);

    public CalculatorResource(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping
    public String[] history() {
        return "bonjour".split("");
    }

    @GetMapping("/operation")
    public String operation() {
        return "This page is for new operation";
    }

    @PostMapping("/operation")
    public String calcul(@RequestBody OperationDto operationDto) {
        logger.info("New operation from expression: " + operationDto.getExpression());
        return String.valueOf(this.calculatorService.multiOperation(operationDto.getExpression()));
    }
}
