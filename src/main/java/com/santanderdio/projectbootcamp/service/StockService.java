package com.santanderdio.projectbootcamp.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.santanderdio.projectbootcamp.exceptions.BusinessException;
import com.santanderdio.projectbootcamp.exceptions.NotFoundException;
import com.santanderdio.projectbootcamp.mapper.StockMapper;
import com.santanderdio.projectbootcamp.model.Stock;
import com.santanderdio.projectbootcamp.model.dto.StockDTO;
import com.santanderdio.projectbootcamp.repository.StockRepository;
import com.santanderdio.projectbootcamp.util.MessageUtils;

@Service
public class StockService {

	@Autowired
	private StockRepository repository;

	@Autowired
	private StockMapper mapper;

	@Transactional
	public StockDTO save(StockDTO dto) {

		// Verificando se objeto já existe
		Optional<Stock> optional = repository.findByNameAndDate(dto.getName(), dto.getDate());

		if (optional.isPresent()) {
			throw new BusinessException(MessageUtils.STOCK_ALREADY_EXISTS);
		}

		Stock stock = mapper.toEntity(dto);
		repository.save(stock);
		return mapper.toDTO(stock);
	}

	@Transactional
	public StockDTO update(StockDTO dto) {

		// Verifica se mais de um objeto atende aos critérios de busca, para evitar que
		// mais de um objeto seja atualizado
		Optional<Stock> optional = repository.findByStockUpdate(dto.getName(), dto.getDate(), dto.getId());

		if (optional.isPresent()) {
			throw new BusinessException(MessageUtils.MORE_THAN_ONE_FIND);
		}

		Stock stock = mapper.toEntity(dto);
		repository.save(stock);
		return mapper.toDTO(stock);
	}

	// O readOnly indica que será apenas uma transaction de consulta, sem alterações
	// no banco de dados
	@Transactional(readOnly = true)
	public List<StockDTO> findAll() {

		return mapper.toDTO(repository.findAll());
	}

	@Transactional(readOnly = true)
	public StockDTO findById(Long id) {

		return repository.findById(id).map(mapper::toDTO).orElseThrow(NotFoundException::new);
	}

	@Transactional(readOnly = true)
	public List<StockDTO> findByCurrentDate() {
		return repository.findByCurrentDate(LocalDate.now()).map(mapper::toDTO).orElseThrow(NotFoundException::new);
	}

	@Transactional
	public StockDTO delete(Long id) {
		StockDTO dto = findById(id);
		repository.deleteById(dto.getId());

		return dto;
	}

}
