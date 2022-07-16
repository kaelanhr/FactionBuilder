package com.example.demo.dtos

import com.example.demo.Const
import com.example.demo.models.Faction
import com.example.demo.models.Organisation
import java.util.*

class OrganisationDto(
    var id: UUID = UUID.fromString(Const.EMPTY_GUID),
    var name: String = "",
    var description: String = "",
    var faction_id: UUID = UUID.fromString(Const.EMPTY_GUID),
    var parentOrganisation: Organisation? = Organisation(),
    var subOrganisation: Set<Organisation> = emptySet()
) {

    fun toEntity(): Organisation {
        return Organisation(id, name, description, faction = Faction(id = faction_id))
    }

    fun loadEntity(organisation: Organisation): OrganisationDto {
        id = organisation.id
		name  = organisation.name
        description = organisation.description
		faction_id  = organisation.faction.id
		parentOrganisation = organisation.parentOrganisation
		subOrganisation = organisation.subOrganisation
        return this
    }
}

