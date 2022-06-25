package com.example.demo.services

import com.example.demo.models.City
import com.example.demo.repositories.HelloWorldRepository
import org.springframework.stereotype.Service

@Service
class HelloWorldServiceImpl(private val helloWorldRepository: HelloWorldRepository): HelloWorldService {
    override fun createCity() {
        val city = City();
        city.id = 1
        city.status = "hey2"
        city.todoDescription = "enter a description"
        city.todoTargetDate = "i am not sure what goes here"

        helloWorldRepository.save(city)
    }
}