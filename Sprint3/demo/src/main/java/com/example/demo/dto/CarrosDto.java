package com.example.demo.dto;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import com.example.demo.modelo.Carros;

public class CarrosDto {
	
	private Long id;
	private String chassi;
	private String nome;
	private String marca;
	private String cor;
	private BigDecimal valor;
	private int anoFabricacao;
	
	
	public CarrosDto(Carros carros) {
		this.id = carros.getId();
		this.chassi = carros.getChassi();
		this.nome = carros.getNome();
		this.marca = carros.getMarca();
		this.cor = carros.getCor();
		this.valor = carros.getValor();
		this.anoFabricacao = carros.getAnoFabricacao();
	}


	
	
	public Long getId() {
		return id;
	}




	public String getChassi() {
		return chassi;
	}




	public String getNome() {
		return nome;
	}




	public String getMarca() {
		return marca;
	}




	public String getCor() {
		return cor;
	}




	public BigDecimal getValor() {
		return valor;
	}




	public int getAnoFabricacao() {
		return anoFabricacao;
	}




	public static List<CarrosDto> converter(List<Carros> carros) {
		return carros.stream().map(CarrosDto::new).collect(Collectors.toList());
	}
}
