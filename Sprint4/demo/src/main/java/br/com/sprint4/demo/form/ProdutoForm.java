package br.com.sprint4.demo.form;

import java.math.BigDecimal;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.sprint4.demo.modelo.Produto;

public class ProdutoForm {
	
	
	
	@NotBlank
	private String descricao;	
	@NotNull
	private BigDecimal precoUnitario;
	

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getPrecoUnitaraio() {
		return precoUnitario;
	}

	public void setPrecoUnitaraio(BigDecimal precoUnitaraio) {
		this.precoUnitario = precoUnitaraio;
	}

	public Produto converter() {		
		return new Produto(descricao, precoUnitario);
	}

	

	
		
	
	
	
}
