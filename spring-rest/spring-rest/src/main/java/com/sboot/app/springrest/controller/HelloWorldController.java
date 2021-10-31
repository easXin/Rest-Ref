package com.sboot.app.springrest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// returns a response body to user
@RestController  //  restController  = controller + responseBody
public class HelloWorldController {
    // get post put delete   =>  Json or XML format

    // Get http method
    // http://localhost:8080/hello-word
    @GetMapping("hello-world")
    public String helloWorld(){
        return "Hello";
    }
}
