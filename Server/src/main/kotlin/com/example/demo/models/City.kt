package com.example.demo.models

import java.util.UUID
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class City(
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	override var id: UUID = UUID.randomUUID(),

	var description: String,

	var status: String
): AbstractModel() {
}