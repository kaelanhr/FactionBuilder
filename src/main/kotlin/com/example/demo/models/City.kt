package com.example.demo.models

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class City(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id:Int = 0,

    var todoDescription:String,

    var todoTargetDate:String,

    var status:String

) {
    constructor():this(0,"","","")
}