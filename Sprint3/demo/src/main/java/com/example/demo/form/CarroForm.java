package com.example.demo.form;

import java.math.BigDecimal;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.example.demo.modelo.Carros;
import com.example.demo.repository.CarroRepository;
import com.sun.istack.NotNull;



public class CarroForm {
	
	@NotBlank @NotEmpty @Length(max=20)
	private String chassi;
	@NotEmpty @NotBlank 
	private String nome;
	@NotEmpty @NotBlank
	private String marca;
	@NotEmpty @NotBlank
	private String cor;
	@NotNull
	private BigDecimal valor;
	@NotNull 
	private int anoFabricacao;
	
	
	
	public String getChassi() {
		return chassi;
	}
	public void setChassi(String chassi) {
		this.chassi = chassi;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	
	 public int getAnoFabricacao() {
		return anoFabricacao;
	}
	public void setAnoFabricacao(int anoFabricacao) {
		this.anoFabricacao = anoFabricacao;
	}
	public Carros converter(CarroRepository carroRepository) {
		 Carros carro = carroRepository.findByNome(nome);
		 return new Carros(chassi, nome, marca, cor, valor, anoFabricacao);
	}
}
	
	
