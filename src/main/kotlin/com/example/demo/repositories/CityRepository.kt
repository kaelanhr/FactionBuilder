package com.example.demo.repositories

import com.example.demo.models.City
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface CityRepository: CrudRepository<City, UUID> {
}