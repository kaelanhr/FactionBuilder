package com.example.demo.models

import java.util.*
import javax.persistence.*

@Entity
class Organisation(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: UUID = UUID.randomUUID(),

    //    The name of the organisation
    var name: String,

    //    Description of the organisation
    var description: String,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="faction_id", nullable = true)
    private var faction: Faction

    ) {
}