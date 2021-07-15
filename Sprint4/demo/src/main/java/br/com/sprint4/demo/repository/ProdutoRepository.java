package br.com.sprint4.demo.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.sprint4.demo.modelo.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

	Page<Produto> findByDescricao(String descricao, Pageable paginacao);

	

	
}