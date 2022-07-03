package com.example.demo.controllers

import com.example.demo.Const
import com.example.demo.dtos.CityDto
import com.example.demo.services.CityService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
@RequestMapping("/api/city")
class CityControllerImpl(val service: CityService) : EntityController<CityDto> {
	@PostMapping
	override fun create(@RequestBody entity: CityDto): ResponseEntity<CityDto> {
		return ResponseEntity<CityDto>(entity.loadEntity(service.create(entity.toEntity())), HttpStatus.CREATED)
	}

	@PutMapping
	override fun update(@RequestBody entity: CityDto): ResponseEntity<CityDto> {
		if (entity.id.toString() == Const.EMPTY_GUID) {
			return ResponseEntity<CityDto>(null, HttpStatus.BAD_REQUEST)
		}
		return ResponseEntity<CityDto>(CityDto().loadEntity(service.update(entity.toEntity())), HttpStatus.OK)
	}

	@GetMapping("{id}")
	override fun getById(@PathVariable id: UUID): ResponseEntity<CityDto> {
		return ResponseEntity<CityDto>(CityDto().loadEntity(service.getById(id)), HttpStatus.OK)
	}

	@GetMapping
	override fun get(): ResponseEntity<List<CityDto>> {
		val cities = service.get().map { CityDto().loadEntity(it) }
		return ResponseEntity<List<CityDto>>(cities, HttpStatus.OK)
	}

	@DeleteMapping("{id}")
	override fun delete(@PathVariable id: UUID): ResponseEntity<UUID> {
		service.delete(id)
		return ResponseEntity<UUID>(id, HttpStatus.OK)
	}
}