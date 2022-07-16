package com.example.demo.services

import com.example.demo.models.Organisation
import com.example.demo.repositories.OrganisationRepository
import org.springframework.stereotype.Service

@Service
class OrganisationServiceImpl(
	organisationRepository: OrganisationRepository
) : CrudServiceImpl<Organisation>(organisationRepository) {
}