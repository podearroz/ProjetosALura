package br.com.sprint4.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.sprint4.demo.modelo.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

}
