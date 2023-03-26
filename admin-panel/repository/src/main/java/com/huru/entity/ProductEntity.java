package com.huru.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "product")

public class ProductEntity {
	public ProductEntity() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public ProductEntity(long id, String name, String description, String imageUrl, int amount, int quantity,
			String termsAndConditions) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.imageUrl = imageUrl;
		this.amount = amount;
		this.quantity = quantity;
		this.termsAndConditions = termsAndConditions;
	}

	@Column(name = "product_name")

	private String name;

	@Column(name = "product_description")
	private String description;

	@Column(name = "product_img")
	private String imageUrl;

	@Column(name = "product_amount")
	private int amount;

	@Column(name = "quantity")
	private int quantity;

	@Column(name = "product_terms_and_conditions")
	private String termsAndConditions;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getTermsAndConditions() {
		return termsAndConditions;
	}

	public void setTermsAndConditions(String termsAndConditions) {
		this.termsAndConditions = termsAndConditions;
	}

}
