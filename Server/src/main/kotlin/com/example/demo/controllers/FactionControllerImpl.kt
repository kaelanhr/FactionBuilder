package com.example.demo.controllers

import com.example.demo.Const
import com.example.demo.dtos.FactionDto
import com.example.demo.exceptions.CannotSpecifyIdException
import com.example.demo.models.Faction
import com.example.demo.services.CrudService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/api/faction")
class FactionControllerImpl(val service: CrudService<Faction>) : EntityController<FactionDto> {
	@PostMapping
	override fun create(@RequestBody entity: FactionDto): ResponseEntity<FactionDto> {
		if (entity.id.toString() != Const.EMPTY_GUID) {
			throw CannotSpecifyIdException()
		}
		return ResponseEntity<FactionDto>(entity.loadEntity(service.create(entity.toEntity())), HttpStatus.CREATED)
	}

	@PutMapping
	override fun update(@RequestBody entity: FactionDto): ResponseEntity<FactionDto> {
		if (entity.id.toString() == Const.EMPTY_GUID) {
			return ResponseEntity<FactionDto>(null, HttpStatus.BAD_REQUEST)
		}
		return ResponseEntity<FactionDto>(FactionDto().loadEntity(service.update(entity.toEntity())), HttpStatus.OK)
	}

	@GetMapping("{id}")
	override fun getById(@PathVariable id: UUID): ResponseEntity<FactionDto> {
		return ResponseEntity<FactionDto>(FactionDto().loadEntity(service.getById(id)), HttpStatus.OK)
	}

	@GetMapping
	override fun get(): ResponseEntity<List<FactionDto>> {
		val orgs = service.get().map { FactionDto().loadEntity(it) }
		return ResponseEntity<List<FactionDto>>(orgs, HttpStatus.OK)
	}

	@DeleteMapping("{id}")
	override fun delete(@PathVariable id: UUID): ResponseEntity<UUID> {
		service.delete(id)
		return ResponseEntity<UUID>(id, HttpStatus.OK)
	}
}