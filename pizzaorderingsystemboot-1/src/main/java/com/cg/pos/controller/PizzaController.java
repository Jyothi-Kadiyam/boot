package com.cg.pos.controller;

import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.pos.entity.PizzaDetailsDTO;
import com.cg.pos.exception.PizzaException;
import com.cg.pos.service.PizzaService;
import com.cg.pos.utility.Exceptions;

@RestController
@ControllerAdvice

public class PizzaController {
//	  Logger logger = LoggerFactory.getLogger(PizzaController.class);
	Logger logger = LoggerFactory.getLogger(PizzaController.class);


	
	
	@Autowired
	private PizzaService pizzaService;
	
	

	PizzaDetailsDTO detailsDTO = new PizzaDetailsDTO();

	@PutMapping(value = "modify", produces = "application/json", consumes = "application/json")
	public PizzaDetailsDTO modifyName(@RequestBody PizzaDetailsDTO dto) throws PizzaException {
		logger.info("modify method started");

		System.out.println("controller");
		detailsDTO = pizzaService.modify(dto);
		if (detailsDTO == null) {
			logger.error("modify method stopped with exception");
			throw new PizzaException(Exceptions.INVALID_ID);
		} else {
			logger.info("modify method stopped");
			return detailsDTO;
		}
	}

	@PutMapping(value = "delete", headers = "Accept=application/json")
	public PizzaDetailsDTO delete(@RequestBody PizzaDetailsDTO dto) throws PizzaException {
		logger.info("delete method started");

		detailsDTO = pizzaService.deletePizzaDetails(dto);

		if (detailsDTO == null) {
			logger.error("delete method stopped with exception");
			throw new PizzaException(Exceptions.INVALID_ID);
		}
		logger.info("delete method stopped");
		return detailsDTO;
	}

}

