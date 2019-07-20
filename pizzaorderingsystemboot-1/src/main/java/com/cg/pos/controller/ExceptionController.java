package com.cg.pos.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import com.cg.pos.entity.ExceptionDTO;
import com.cg.pos.exception.PizzaException;
@ControllerAdvice
@RestController
public class ExceptionController {
	
	@ExceptionHandler(PizzaException.class)
	public ResponseEntity<ExceptionDTO> errorHandle(PizzaException ex,WebRequest request){
		
		ExceptionDTO exception=new ExceptionDTO(ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(exception,HttpStatus.BAD_REQUEST);
		
	}

}

