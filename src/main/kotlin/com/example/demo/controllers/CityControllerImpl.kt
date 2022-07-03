package com.example.demo.controllers

import com.example.demo.Const
import com.example.demo.dtos.CityDto
import com.example.demo.exceptions.CannotSpecifyIdException
import com.example.demo.models.City
import com.example.demo.services.CrudService
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/api/city")
class CityControllerImpl(val service: CrudService<City>) : EntityController<CityDto> {
	@PostMapping
	override fun create(@RequestBody entity: CityDto): ResponseEntity<CityDto> {
		if (entity.id.toString() != Const.EMPTY_GUID) {
			throw CannotSpecifyIdException()
		}
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