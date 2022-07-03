package com.example.demo.services

import com.example.demo.exceptions.EntityNotFoundException
import com.example.demo.models.City
import com.example.demo.repositories.CityRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.util.*

@Service
class CityServiceImpl(
    private val cityRepository: CityRepository
) : CityService {

    override fun get(): Iterable<City> {
        return cityRepository.findAll()
    }

    override fun getById(id: UUID): City {
        return  cityRepository.findByIdOrNull(id) ?: throw EntityNotFoundException("Entity not found.")
    }

    override fun create(entity: City): City {
        return cityRepository.save(entity)
    }

    override fun update(entity: City): City {
        cityRepository.findByIdOrNull(entity.id) ?: throw EntityNotFoundException("Entity to update not found.")
        return cityRepository.save(entity)
    }

    override fun delete(id: UUID) {
        cityRepository.deleteById(id)
    }
}