package com.cg.pos.dao;

import com.cg.pos.entity.PizzaDetailsDTO;
import com.cg.pos.exception.PizzaException;

public interface PizzaDao {

	PizzaDetailsDTO delete(PizzaDetailsDTO detailsDTO) throws PizzaException;

	PizzaDetailsDTO modify(PizzaDetailsDTO detailsDTO) throws PizzaException;

}
