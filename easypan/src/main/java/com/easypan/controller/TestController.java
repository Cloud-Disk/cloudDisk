package com.easypan.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class TestController {
    @RequestMapping("/test")
    public String test(){
        return "Hello, world! (test)";
    }
}
