package com.example.demo.repositories

import com.example.demo.models.Organisation
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface OrganisationRepository: CrudRepository<Organisation, UUID> {
}