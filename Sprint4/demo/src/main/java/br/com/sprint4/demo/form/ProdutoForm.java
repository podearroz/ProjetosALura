package br.com.sprint4.demo.form;

import java.math.BigDecimal;

import javax.validation.constraints.NotBlank;

import br.com.sprint4.demo.modelo.Produto;

public class ProdutoForm {
	
	
	
	@NotBlank
	private String descricao;	
	
	private BigDecimal preco_unitario;
	

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getPrecoUnitaraio() {
		return preco_unitario;
	}

	public void setPrecoUnitaraio(BigDecimal precoUnitaraio) {
		this.preco_unitario = precoUnitaraio;
	}

	public Produto converter() {		
		return new Produto(descricao, preco_unitario);
	}

	

	
		
	
	
	
}
