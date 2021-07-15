package br.com.sprint4.demo.form;

import java.math.BigDecimal;

import javax.validation.constraints.NotBlank;

import br.com.sprint4.demo.modelo.Produto;
import br.com.sprint4.demo.repository.ProdutoRepository;

public class AtualizacaoProdutoForm {
	
	@NotBlank
	private String descricao;
	@NotBlank
	private BigDecimal precoUnitario;
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public BigDecimal getPrecoUnitario() {
		return precoUnitario;
	}
	public void setPrecoUnitario(BigDecimal precoUnitario) {
		this.precoUnitario = precoUnitario;
	}
	
	public Produto atualizar(Long id, ProdutoRepository produtoRepository) {
		Produto produto = produtoRepository.getOne(id);
		
		produto.setDescricao(this.descricao);
		produto.setPrecoUnitario(this.precoUnitario);
				
		return produto;
	}
}
