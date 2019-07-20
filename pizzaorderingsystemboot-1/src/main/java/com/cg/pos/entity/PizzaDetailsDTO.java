package com.cg.pos.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.transaction.Transactional;
import javax.validation.constraints.Negative;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.NumberFormat;

import com.cg.pos.utility.Exceptions;
@Transactional
@Entity
@Table(name = "pizza")
public class PizzaDetailsDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@NumberFormat
	@Column(name = "itemid")
	private int itemId;
	@NumberFormat
	@Column(name = "storeid")
	private int storeId;
	// private StoreDetailsDTO storeDetails;
	// public StoreDetailsDTO getStoreDetails() {
	// return storeDetails;
	// }
	//
	// public void setStoreDetails(StoreDetailsDTO storeDetails) {
	// this.storeDetails = storeDetails;
	// }

	@Column(name = "pizzaname")
	@Pattern(regexp = "[A-Z][a-zA-Z][^#&<>\\\"~;$^%{}?][^0-9]", message = Exceptions.INVALID_PIZZANAME)
	private String itemName;

	@Negative(message=Exceptions.INVALID_COST)
	@Column(name = "quantity")
	private int quantity;

	
	@NumberFormat
	@Column(name = "price")
	private double cost;

	public PizzaDetailsDTO() {

	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public PizzaDetailsDTO(int itemId, int storeId, String itemName, int quantity, double cost) {

		this.itemId = itemId;
		this.storeId = storeId;
		this.itemName = itemName;
		this.quantity = quantity;
		this.cost = cost;

	}

	@Override
	public String toString() {
		return "PizzaDetails [itemId=" + itemId + ",storeId=" + storeId + ", itemName=" + itemName + ", quantity="
				+ quantity + ", cost=" + cost + "]" + '\n';
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public int getStoreId() {
		return storeId;
	}

	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}

}
