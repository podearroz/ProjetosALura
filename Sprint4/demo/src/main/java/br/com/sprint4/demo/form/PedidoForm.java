package br.com.sprint4.demo.form;

import javax.validation.constraints.NotNull;

import br.com.sprint4.demo.modelo.Pedido;
import br.com.sprint4.demo.modelo.Produto;

public class PedidoForm {
	
	@NotNull
	private Produto produtoid;

	public Produto getProdutoid() {
		return produtoid;
	}

	public void setProdutoid(Produto produtoid) {
		this.produtoid = produtoid;
	}

	public Pedido converter() {
		
		return new Pedido(produtoid);
	}
	
}
