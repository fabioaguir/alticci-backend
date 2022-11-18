package com.alticci.exceptions;

import com.alticci.dtos.ErrorDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;

@ControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler {

	@org.springframework.web.bind.annotation.ExceptionHandler({ StackOverflowError.class })
	public ResponseEntity<Object> handleStackOverflowError(Exception exception, WebRequest request) {
		var message = "Valor indefinido para o ìndice";
		var errors = List.of(new ErrorDto(message));

		return super.handleExceptionInternal(exception, errors.get(0), new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
	}
}
