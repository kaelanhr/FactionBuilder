package com.example.demo.models

import com.fasterxml.jackson.annotation.JsonBackReference
import java.util.*
import javax.persistence.*

@Entity
class Organisation(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    override var id: UUID = UUID.randomUUID(),

    //    The name of the organisation
    var name: String = "",

    //    Description of the organisation
    var description: String = "",

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "faction_id", nullable = true)
    var faction: Faction = Faction(),

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parentOrganisation")
    var parentOrganisation: Organisation? = null,

    @OneToMany(mappedBy = "parentOrganisation")
    var subOrganisation: Set<Organisation> = emptySet()

): AbstractModel() {
}