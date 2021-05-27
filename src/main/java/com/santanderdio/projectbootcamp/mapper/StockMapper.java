package com.santanderdio.projectbootcamp.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.santanderdio.projectbootcamp.model.Stock;
import com.santanderdio.projectbootcamp.model.dto.StockDTO;

/**
 * Mapper é um objeto que converte um tipo de objeto em outro. Nesse contexto,
 * ele irá converter um objeto {@link Stock} para um {@link StockDTO}, e
 * vice-versa.
 */
@Component
public class StockMapper {

	public Stock toEntity(StockDTO dto) {

		Stock stock = new Stock();
		stock.setId(dto.getId());
		stock.setName(dto.getName());
		stock.setPrice(dto.getPrice());
		stock.setDate(dto.getDate());
		stock.setVariation(dto.getVariation());

		return stock;
	}

	public StockDTO toDTO(Stock stock) {
		StockDTO dto = new StockDTO();
		dto.setId(stock.getId());
		dto.setName(stock.getName());
		dto.setPrice(stock.getPrice());
		dto.setDate(stock.getDate());
		dto.setVariation(stock.getVariation());

		return dto;
	}

	public List<StockDTO> toDTO(List<Stock> listStock) {

		// Executa o método toDTO() em cada objeto presente na listaStock, depois coleta
		// os resultados e gera uma nova lista, que será retornada
		return listStock.stream().map(this::toDTO).collect(Collectors.toList());
	}

}
