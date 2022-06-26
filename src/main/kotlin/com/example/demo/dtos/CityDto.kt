package com.example.demo.dtos

import com.example.demo.models.City
import java.util.*

class CityDto(
    var id: UUID = UUID.randomUUID(),
    var todoDescription: String,
    var todoTargetDate: String,
    var status: String
) {

    fun loadEntity(city: City): CityDto {
        id = city.id;
        todoDescription = city.todoTargetDate
        todoTargetDate = city.todoTargetDate
        status = city.status
        return this
    }

    fun toEntity(): City {
        return City(id, todoDescription, todoTargetDate, status)
    }
}

