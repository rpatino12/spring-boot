package com.platzi.springboot.fundamentos.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

    // Let's create a function to test if the port and the path of the application is deployed correctly
    @RequestMapping("/") // This annotation is used to accept all the http requests in the method
    @ResponseBody // This is used to create a body response
    public ResponseEntity<String> exampleFunction(){
        return new ResponseEntity<>("<h1>Hello from controller!!</h1><p>This is the response</p>", HttpStatus.OK);
    }
}
