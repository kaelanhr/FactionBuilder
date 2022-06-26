package com.example.demo.services

import com.example.demo.models.City
import com.example.demo.repositories.HelloWorldRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class HelloWorldServiceImpl(
    private val helloWorldRepository: HelloWorldRepository
) : HelloWorldService {
    override fun createCity(city: City): City {
        return helloWorldRepository.save(city)
    }

    override fun deleteCity(id: UUID) {
        helloWorldRepository.deleteById(id)
    }
}