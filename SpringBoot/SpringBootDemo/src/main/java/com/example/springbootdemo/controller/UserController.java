package com.example.springbootdemo.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @RequestMapping("/hello1")
    public String hello() {
        return "hello world0";
    }

    @GetMapping("/hello2")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }

    @RequestMapping("/hi")
    public String hi(){return "hi12312";}

}
/**/