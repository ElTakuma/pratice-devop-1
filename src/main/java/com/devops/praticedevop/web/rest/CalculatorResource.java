package com.devops.praticedevop.web.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/calculator")
public class CalculatorResource {

    @GetMapping
    public String[] history() {
        return "bonjour".split("");
    }
}
