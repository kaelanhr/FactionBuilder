package com.example.demo.controllers

import org.springframework.http.ResponseEntity
import java.util.UUID

interface EntityController<T> {
	fun create(entity: T): ResponseEntity<T>
	fun update(entity: T): ResponseEntity<T>
	fun getById(id: UUID): ResponseEntity<T>
	fun get(): ResponseEntity<List<T>>
	fun delete(id: UUID): ResponseEntity<UUID>
}