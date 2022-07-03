package com.example.demo.exceptions

class EntityNotFoundException(message: String = "Entity could not be found.") : RuntimeException(message) {
}