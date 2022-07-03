package com.example.demo.services

import com.example.demo.exceptions.EntityNotFoundException
import com.example.demo.models.AbstractModel
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.findByIdOrNull
import java.util.*

abstract class CrudServiceImpl<T : AbstractModel>(
	private val crudRepository: CrudRepository<T, UUID>
) : CrudService<T> {

	override fun get(): Iterable<T> {
		return crudRepository.findAll()
	}

	override fun getById(id: UUID): T {
		return crudRepository.findByIdOrNull(id) ?: throw EntityNotFoundException("Entity not found.")
	}

	override fun create(entity: T): T {
		return crudRepository.save(entity)
	}

	override fun update(entity: T): T {
		crudRepository.findByIdOrNull(entity.id) ?: throw EntityNotFoundException("Entity to update not found.")
		return crudRepository.save(entity)
	}

	override fun delete(id: UUID) {
		crudRepository.deleteById(id)
	}
}