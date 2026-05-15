package com.urbanvibe.LojaDeRoupa.controller;

import lombok.Getter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class ControllerHello {
    @GetMapping
    public String sayHello() {
        return "Hello World";
    }
}
