package com.example.demo.controllers

import com.example.demo.const
import com.example.demo.dtos.CityDto
import com.example.demo.services.CityService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.Mapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
@RequestMapping("/api/city")
class CityController(val service: CityService) {
    @PostMapping
    fun create(@RequestBody cityDto: CityDto): ResponseEntity<CityDto> {
        return ResponseEntity<CityDto>(cityDto.loadEntity(service.create(cityDto.toEntity())), HttpStatus.CREATED)
    }

    @PutMapping
    fun update(@RequestBody cityDto: CityDto): ResponseEntity<CityDto> {
        if(cityDto.id.toString() == const.EMPTY_GUID) {
            return ResponseEntity<CityDto>(null, HttpStatus.BAD_REQUEST)
        }
        return ResponseEntity<CityDto>(CityDto().loadEntity(service.update(cityDto.toEntity())), HttpStatus.OK)
    }

    @GetMapping("{id}")
    fun getById(@PathVariable id: UUID): ResponseEntity<CityDto> {
        return ResponseEntity<CityDto>(service.getById(id)?.let { CityDto().loadEntity(it) }, HttpStatus.OK)
    }

    @GetMapping
    fun get(): ResponseEntity<List<CityDto>> {
        val cities = service.get().map { CityDto().loadEntity(it) }
        return ResponseEntity<List<CityDto>>(cities, HttpStatus.OK)
    }

    @DeleteMapping("{id}")
    fun delete(@PathVariable id: UUID): ResponseEntity<UUID> {
        service.delete(id)
        return ResponseEntity<UUID>(id, HttpStatus.OK)
    }
}