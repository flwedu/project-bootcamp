package com.santanderdio.projectbootcamp.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * A entidade é uma classe que reflete as entidades do banco de dados
 */
@Entity
@Table(name = "tb_stock")
public class Stock {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) //Auto: o JPA cuida da criação do id, Identity: o banco de dados cuida
	@Column(name = "id")
	private Long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "price")
	private Double price;

	@Column(name = "date")
	private LocalDate date;
	
	@Column(name = "variation")
	private Double variation;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Double getVariation() {
		return variation;
	}

	public void setVariation(Double variation) {
		this.variation = variation;
	}
	
	
}