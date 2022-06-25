package com.example.demo.controllers

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloWorldController {

    @RequestMapping("/hello")
    fun hello(): String {
        return "Hello World!"
    }
}