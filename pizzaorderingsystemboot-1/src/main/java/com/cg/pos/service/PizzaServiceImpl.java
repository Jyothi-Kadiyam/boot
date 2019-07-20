package com.cg.pos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.pos.dao.PizzaDao;
import com.cg.pos.entity.PizzaDetailsDTO;
import com.cg.pos.exception.PizzaException;

@Service

public class PizzaServiceImpl implements PizzaService {

	@Autowired
	private PizzaDao dao;
	
//	public void setDao(PizzaDao dao) {
//		this.dao = dao;
//	}

	public PizzaDetailsDTO deletePizzaDetails(PizzaDetailsDTO detailsDTO) throws PizzaException {
		return dao.delete(detailsDTO);
		
	}

	public PizzaDetailsDTO modify(PizzaDetailsDTO detailsDTO) throws PizzaException {
		return dao.modify(detailsDTO);

	}
}
