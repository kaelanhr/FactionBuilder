package com.example.demo.services

import com.example.demo.models.Faction
import com.example.demo.repositories.FactionRepository
import org.springframework.stereotype.Service

@Service
class FactionServiceImpl(
	factionRepository: FactionRepository
) : CrudServiceImpl<Faction>(factionRepository) {
}