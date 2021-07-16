package br.com.sprint4.demo.modelo;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Produto {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String descricao;
	private BigDecimal preco_unitario;
	
	public Produto() {
		
	}
	
	public Produto(String descricao,BigDecimal preco_unitario) {
		this.descricao= descricao;
		this.preco_unitario= preco_unitario;
	}
	 
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public BigDecimal getPrecoUnitario() {
		return preco_unitario;
	}
	public void setPrecoUnitario(BigDecimal preco_unitario) {
		this.preco_unitario = preco_unitario;
	}

	
	
	
}
