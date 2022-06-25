package com.example.demo.controllers

import com.example.demo.services.HelloWorldService
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloWorldController(val service: HelloWorldService) {

    @RequestMapping("/hello")
    fun hello(): String {
        val value = service.createCity();
        return "Hello World!"
    }
}