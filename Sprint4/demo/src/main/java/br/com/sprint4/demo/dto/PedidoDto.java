package br.com.sprint4.demo.dto;

import org.springframework.data.domain.Page;

import br.com.sprint4.demo.modelo.Pedido;
import br.com.sprint4.demo.modelo.Produto;

public class PedidoDto {
	
	private Produto produtoid;

	public Produto getProdutoid() {
		return produtoid;
	}
	

	public PedidoDto() {
		
		
	}


	public void setProdutoid(Produto produtoid) {
		this.produtoid = produtoid;
	}


	public static Page<Pedido> converter(Page<Pedido> pedidos) {		
		return pedidos;
	}

	
	
}
