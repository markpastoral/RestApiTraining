package com.trainig.restapidemo.helloworld;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping("/hello-world")
    public String printHelloWorld() {
        return "Hello World!";
    }

    @GetMapping("/hello-world-bean")
    public ResponseEntity<HelloWorldBean> getHelloWorldBean() {
        return new ResponseEntity<>(new HelloWorldBean("Hello World"), HttpStatus.OK);
    }

    @GetMapping("/hello-world-bean/{name}")
    public ResponseEntity<HelloWorldBean> getHelloWorldBean(@PathVariable String name) {
        return new ResponseEntity<>(new HelloWorldBean(String.format("Hello World, %s", name)), HttpStatus.OK);
    }
}
