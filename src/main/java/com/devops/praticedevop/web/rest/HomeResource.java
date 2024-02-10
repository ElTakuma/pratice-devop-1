package com.devops.praticedevop.web.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
public class HomeResource {

    @GetMapping
    public String index() {
        return "Welcome to you";
    }
}
