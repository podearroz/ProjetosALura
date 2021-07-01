package com.example.demo.form;

import java.math.BigDecimal;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.example.demo.modelo.Carros;
import com.example.demo.repository.CarroRepository;
import com.sun.istack.NotNull;

public class AtualizacaoCarroForm {
	
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
	
	
	public void setChassi(String chassi) {
		this.chassi = chassi;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	public void setAnoFabricacao(int anoFabricacao) {
		this.anoFabricacao = anoFabricacao;
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
	public Carros atualizar(Long id, CarroRepository carroRepository) {
		Carros carro = carroRepository.getOne(id);
		carro.setChassi(this.chassi);
		carro.setNome(this.nome);
		carro.setMarca(this.marca);
		carro.setCor(this.cor);
		carro.setValor(this.valor);
		carro.setAnoFabricacao(this.anoFabricacao);
		return carro;
	}
}
