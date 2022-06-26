package com.example.demo.controllers

import com.example.demo.dtos.CityDto
import com.example.demo.services.HelloWorldService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
class HelloWorldController(val service: HelloWorldService) {

    @PostMapping("/hello")
    fun hello(@RequestBody cityDto: CityDto): ResponseEntity<CityDto> {
        return ResponseEntity<CityDto>(cityDto.loadEntity(service.createCity(cityDto.toEntity())), HttpStatus.CREATED)
    }

    @DeleteMapping("/delete/city/{id}")
    fun hello(@PathVariable id: UUID): ResponseEntity<UUID> {
        service.deleteCity(id)
        return ResponseEntity<UUID>(id, HttpStatus.OK)
    }
}