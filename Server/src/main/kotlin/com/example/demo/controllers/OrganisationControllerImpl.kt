package com.example.demo.controllers

import com.example.demo.Const
import com.example.demo.dtos.OrganisationDto
import com.example.demo.exceptions.CannotSpecifyIdException
import com.example.demo.models.Organisation
import com.example.demo.services.CrudService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/api/organisation")
class OrganisationControllerImpl(val service: CrudService<Organisation>) : EntityController<OrganisationDto> {
	@PostMapping
	override fun create(@RequestBody entity: OrganisationDto): ResponseEntity<OrganisationDto> {
		if (entity.id.toString() != Const.EMPTY_GUID) {
			throw CannotSpecifyIdException()
		}
		return ResponseEntity<OrganisationDto>(entity.loadEntity(service.create(entity.toEntity())), HttpStatus.CREATED)
	}

	@PutMapping
	override fun update(@RequestBody entity: OrganisationDto): ResponseEntity<OrganisationDto> {
		if (entity.id.toString() == Const.EMPTY_GUID) {
			return ResponseEntity<OrganisationDto>(null, HttpStatus.BAD_REQUEST)
		}
		return ResponseEntity<OrganisationDto>(OrganisationDto().loadEntity(service.update(entity.toEntity())), HttpStatus.OK)
	}

	@GetMapping("{id}")
	override fun getById(@PathVariable id: UUID): ResponseEntity<OrganisationDto> {
		return ResponseEntity<OrganisationDto>(OrganisationDto().loadEntity(service.getById(id)), HttpStatus.OK)
	}

	@GetMapping
	override fun get(): ResponseEntity<List<OrganisationDto>> {
		val orgs = service.get().map { OrganisationDto().loadEntity(it) }
		return ResponseEntity<List<OrganisationDto>>(orgs, HttpStatus.OK)
	}

	@DeleteMapping("{id}")
	override fun delete(@PathVariable id: UUID): ResponseEntity<UUID> {
		service.delete(id)
		return ResponseEntity<UUID>(id, HttpStatus.OK)
	}
}