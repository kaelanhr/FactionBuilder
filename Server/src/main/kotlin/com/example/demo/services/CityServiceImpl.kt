package com.example.demo.services

import com.example.demo.models.City
import com.example.demo.repositories.CityRepository
import org.springframework.stereotype.Service

@Service
class CityServiceImpl(
	cityRepository: CityRepository
) : CrudServiceImpl<City>(cityRepository) {
}