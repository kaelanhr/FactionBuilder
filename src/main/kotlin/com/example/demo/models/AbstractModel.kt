package com.example.demo.models

import java.util.*
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

abstract class AbstractModel {
	abstract var id: UUID;
}