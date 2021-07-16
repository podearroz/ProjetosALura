package br.com.sprint4.demo.dto;

import java.math.BigDecimal;

import org.springframework.data.domain.Page;

import br.com.sprint4.demo.modelo.Produto;

public class ProdutoDto {
	
	
	public ProdutoDto(Produto produto) {
		
		
		this.descricao = produto.getDescricao();
		this.preco_unitario = produto.getPrecoUnitario();
	}

	public ProdutoDto() {
		
	}

	
	
	private String descricao;
	private BigDecimal preco_unitario;
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public BigDecimal getPrecoUnitario() {
		return preco_unitario;
	}
	public void setPrecoUnitario(BigDecimal precoUnitario) {
		this.preco_unitario = precoUnitario;
	}
	
	
	public static Page<ProdutoDto> converter(Page<Produto> produto) {
		return produto.map(ProdutoDto::new);
	
	}

	}
