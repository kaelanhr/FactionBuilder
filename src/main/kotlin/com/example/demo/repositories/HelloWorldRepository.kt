package com.example.demo.repositories

import com.example.demo.models.City
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface HelloWorldRepository: CrudRepository<City, Long> {
}