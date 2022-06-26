package com.example.demo.repositories

import com.example.demo.models.City
import com.example.demo.models.Faction
import com.example.demo.models.Organisation
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface OrganisationRepository: CrudRepository<Organisation, Long> {
}