package com.devops.praticedevop.web.rest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class HomeResource {

    @GetMapping
    public String index(Model model) {
        // Add any necessary data to the model
        model.addAttribute("message", "Welcome to the new page!");

        // Return the logical view name of the page
        return "home";
    }
}
