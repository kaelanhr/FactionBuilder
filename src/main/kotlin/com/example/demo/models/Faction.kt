package com.example.demo.models

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.OneToMany

@Entity
data class Faction(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id:Int = 0,

    var name: String,

    var origin: String,

    @OneToMany(mappedBy = "faction")
    var organisations: Set<Organisation> = emptySet()
) {
}