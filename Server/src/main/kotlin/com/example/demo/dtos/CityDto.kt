package com.example.demo.dtos

import com.example.demo.Const
import com.example.demo.models.City
import java.util.*

class CityDto(
	var id: UUID = UUID.fromString(Const.EMPTY_GUID),
	var description: String = "",
	var status: String = ""
) {

	fun loadEntity(city: City): CityDto {
		id = city.id;
		description = city.description
		status = city.status
		return this
	}

	fun toEntity(): City {
		return City(id, description, status)
	}
}
