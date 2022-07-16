package com.example.demo.repositories

import com.example.demo.models.Faction
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface FactionRepository: CrudRepository<Faction, UUID> {
}