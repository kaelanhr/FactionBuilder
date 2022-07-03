package com.example.demo.services

import com.example.demo.models.City
import java.util.UUID

interface CrudService<T> {
	fun get(): Iterable<T>
	fun getById(id: UUID): T
	fun create(entity: T): T
	fun update(entity: T): T
	fun delete(id: UUID): Unit
}