package com.example.demo.exceptions

class CannotSpecifyIdException(message: String  =  "You cannot specify the Id") : RuntimeException(message) {
}