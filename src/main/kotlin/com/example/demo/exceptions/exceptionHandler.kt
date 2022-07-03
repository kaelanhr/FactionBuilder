package com.example.demo.exceptions

import org.springframework.dao.EmptyResultDataAccessException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

class ErrorMessageModel(
	var status: Int? = null,
	var message: String? = null
)

@ControllerAdvice
class ExceptionControllerAdvice {

	@ExceptionHandler
	fun handleEmptyResultDataException(ex: EmptyResultDataAccessException): ResponseEntity<ErrorMessageModel> {
		return handleException("Entity could not be found", HttpStatus.NOT_FOUND)
	}

	@ExceptionHandler
	fun handleEntityNotFoundException(ex: EntityNotFoundException): ResponseEntity<ErrorMessageModel> {
		return handleException(ex.message, HttpStatus.NOT_FOUND)
	}

	@ExceptionHandler
	fun handleCannotSpecifyIdException(ex: CannotSpecifyIdException): ResponseEntity<ErrorMessageModel> {
		return handleException(ex.message, HttpStatus.BAD_REQUEST)
	}

	fun handleException(message: String?, status: HttpStatus): ResponseEntity<ErrorMessageModel> {
		val errorMessage = ErrorMessageModel(
			status.value(),
			message
		)
		return ResponseEntity(errorMessage, status)
	}
}