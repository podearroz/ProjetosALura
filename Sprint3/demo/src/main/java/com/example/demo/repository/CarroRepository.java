package com.example.demo.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.example.demo.modelo.Carros;

public interface CarroRepository extends JpaRepository<Carros, Long>, PagingAndSortingRepository<Carros, Long>{

	List<Carros> findByNome(String nome);

	List<Carros> findByCor(String cor);

	List<Carros> findByMarca(String marca);
	
	List<Carros> findByValor(BigDecimal valor, Pageable pageable);
//	List<Carros> findByAno(int anoFabricacao);
	
	


	

}
