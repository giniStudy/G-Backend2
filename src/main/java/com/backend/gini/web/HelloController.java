package com.backend.gini.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/health")
public class HelloController {

    @GetMapping("/ping")
    public String test() {
        return "ping";
    }
}
