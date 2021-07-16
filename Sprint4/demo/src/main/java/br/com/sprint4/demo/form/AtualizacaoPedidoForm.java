package br.com.sprint4.demo.form;

import javax.validation.constraints.NotNull;

import br.com.sprint4.demo.modelo.Pedido;
import br.com.sprint4.demo.modelo.Produto;
import br.com.sprint4.demo.repository.PedidoRepository;

public class AtualizacaoPedidoForm {
	
	@NotNull
	private Produto produtoid;

	public Produto getProdutoid() {
		return produtoid;
	}

	public void setProdutoid(Produto produtoid) {
		this.produtoid = produtoid;
	}
	public Pedido atualizar(Long id, PedidoRepository pedidoRepository) {
		Pedido pedido = pedidoRepository.getOne(id);
		
		pedido.setProdutoid(produtoid);
		
				
		return pedido;
	}
}
