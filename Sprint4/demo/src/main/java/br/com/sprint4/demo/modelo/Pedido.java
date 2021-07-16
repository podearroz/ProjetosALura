package br.com.sprint4.demo.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Pedido {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	private Produto produtoid;
	
	
	public Pedido(Produto produtoid) {
		this.produtoid = produtoid;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Produto getProdutoid() {
		return produtoid;
	}
	public void setProdutoid(Produto produtoid) {
		this.produtoid = produtoid;
	}
	
	
}
