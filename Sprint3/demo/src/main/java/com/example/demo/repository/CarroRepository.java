package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.modelo.Carros;

public interface CarroRepository extends JpaRepository<Carros, Long> {

	List<Carros> findByNome(String nome);

	List<Carros> findByCor(String cor);
	
	

}
