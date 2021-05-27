package com.santanderdio.projectbootcamp.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.santanderdio.projectbootcamp.model.dto.StockDTO;
import com.santanderdio.projectbootcamp.service.StockService;

@CrossOrigin
@RestController
@RequestMapping(value = "/stock")
public class StockController {

	@Autowired
	private StockService service;

	/**
	 * Método de criação de um novo objeto na base de dados.
	 * <p>
	 * <b>consumes</b> = tipo de dado aceito no RequestBody.
	 * <p>
	 * produces = tipo de dado que será respondido.
	 * 
	 * @param stockdto
	 * @return
	 */
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StockDTO> save(@Valid @RequestBody StockDTO stockdto) {

		return ResponseEntity.ok(service.save(stockdto));

	}

	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StockDTO> update(@RequestBody StockDTO stockdto) {

		return ResponseEntity.ok(service.update(stockdto));
	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<StockDTO>> findAll() {

		return ResponseEntity.ok(service.findAll());

	}

	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StockDTO> findById(@PathVariable Long id) {

		return ResponseEntity.ok(service.findById(id));
	}
	
	@GetMapping(value = "today", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<StockDTO>> findByCurrentDate(){
		
		return ResponseEntity.ok(service.findByCurrentDate());
	}
	
	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StockDTO> delete(@PathVariable Long id){
		return ResponseEntity.ok(service.delete(id));
	}
}
