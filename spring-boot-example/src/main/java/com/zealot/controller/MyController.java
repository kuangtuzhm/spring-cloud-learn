package com.zealot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @RequestMapping("/hi")
    public String home() {
        return "hi zhm!";
    }
}
