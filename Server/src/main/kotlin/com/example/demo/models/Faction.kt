package com.example.demo.models

import java.util.*
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.OneToMany

@Entity
data class Faction(
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	override var id: UUID = UUID.randomUUID(),

	var name: String = "",

	var origin: String = "",

	@OneToMany(mappedBy = "faction")
	var organisations: Set<Organisation> = emptySet()
):  AbstractModel() {
}