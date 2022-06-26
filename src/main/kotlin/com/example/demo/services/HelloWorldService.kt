package com.example.demo.services

import com.example.demo.models.City
import java.util.UUID

interface HelloWorldService {
    fun createCity(city: City): City
    fun deleteCity(id: UUID)
}