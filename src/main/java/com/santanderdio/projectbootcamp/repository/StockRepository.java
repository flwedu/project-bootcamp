package com.santanderdio.projectbootcamp.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.santanderdio.projectbootcamp.model.Stock;

@Repository
public interface StockRepository extends JpaRepository<Stock, Long> {

	//Localiza por nome e data
	Optional<Stock> findByNameAndDate(String name, LocalDate date);

	//Localiza algum objeto com os mesmos dados, porém com IDs diferentes
	@Query("SELECT stock FROM Stock stock "
			+ "WHERE stock.name = :name "
			+ "AND stock.date = :date "
			+ "AND stock.id <> :id")
	Optional<Stock> findByStockUpdate(String name, LocalDate date, Long id);

	//Retorna os objetos com a mesma data que hoje
	@Query("SELECT stock FROM Stock stock "
			+ "WHERE stock.date = :date")
	Optional<List<Stock>> findByCurrentDate(LocalDate date);

}
