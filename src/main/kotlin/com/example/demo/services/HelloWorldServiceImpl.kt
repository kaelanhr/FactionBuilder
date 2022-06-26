package com.example.demo.services

import com.example.demo.models.City
import com.example.demo.models.Faction
import com.example.demo.models.Organisation
import com.example.demo.repositories.FactionRepository
import com.example.demo.repositories.HelloWorldRepository
import com.example.demo.repositories.OrganisationRepository
import org.springframework.stereotype.Service

@Service
class HelloWorldServiceImpl(
    private val helloWorldRepository: HelloWorldRepository,
    private val factionRepo: FactionRepository,
    private val orgRepo: OrganisationRepository
) : HelloWorldService {
    override fun createCity() {
        val city = City(1, "enter a description", "i am not sure what goes here", "hey2");

        val faction = Faction(1, "galactic empire", "from the republic")
        val organisation = Organisation(1, "imperial navy", "the space ships", faction)
        factionRepo.save(faction)
        orgRepo.save(organisation)
        helloWorldRepository.save(city)
    }
}