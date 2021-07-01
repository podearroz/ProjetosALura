package com.example.demo.repository;

import javax.validation.constraints.NotBlank;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.modelo.Carros;

public interface CarroRepository extends JpaRepository<Carros, Long> {

	Carros findByNome(@NotBlank String nome);

}
