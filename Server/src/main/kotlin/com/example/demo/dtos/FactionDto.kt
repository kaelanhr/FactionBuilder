package com.example.demo.dtos

import com.example.demo.Const
import com.example.demo.models.Faction
import java.util.*
import java.util.stream.Collectors.toSet

class FactionDto(
    var id: UUID = UUID.fromString(Const.EMPTY_GUID),
    var name: String = "",
    var origin: String = "",
    var organisations: Set<OrganisationDto> = emptySet(),
) {

    fun loadEntity(faction: Faction): FactionDto {
        id = faction.id;
        name = faction.name
        origin = faction.origin
        organisations = faction.organisations.stream().map { OrganisationDto().loadEntity(it) }.collect(toSet())
        return this
    }

    fun toEntity(): Faction {
        return Faction(id, name, origin)
    }
}
