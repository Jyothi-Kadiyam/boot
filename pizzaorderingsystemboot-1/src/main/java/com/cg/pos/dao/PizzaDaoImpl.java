package com.cg.pos.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.cg.pos.entity.PizzaDetailsDTO;
import com.cg.pos.exception.PizzaException;

@Repository
@Transactional
public class PizzaDaoImpl implements PizzaDao {

	@PersistenceContext
	private EntityManager em;

//	public void setEm(EntityManager em) {
//		this.em = em;
//	}

	public PizzaDetailsDTO delete(PizzaDetailsDTO detailsDTO) throws PizzaException{
		em.remove(em.find(PizzaDetailsDTO.class, detailsDTO.getItemId()));
		return detailsDTO;
	}

	public PizzaDetailsDTO modify(PizzaDetailsDTO detailsDTO) throws PizzaException{
		PizzaDetailsDTO result = null;
		result = new PizzaDetailsDTO();
		result = em.find(PizzaDetailsDTO.class, detailsDTO.getItemId());
		if (result != null) {
			
			if (detailsDTO.getItemName() != null) {
				result.setItemName(detailsDTO.getItemName());
			}
			if (detailsDTO.getCost() != 0) {
				result.setCost(detailsDTO.getCost());
			}
			if (detailsDTO.getQuantity() != 0) {
				result.setQuantity(detailsDTO.getQuantity());
			}
		}
		return result;
	}
}
