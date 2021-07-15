package br.com.sprint4.demo.controller;

import java.net.URI;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.sprint4.demo.dto.ProdutoDto;
import br.com.sprint4.demo.form.AtualizacaoProdutoForm;
import br.com.sprint4.demo.form.ProdutoForm;
import br.com.sprint4.demo.modelo.Produto;
import br.com.sprint4.demo.repository.ProdutoRepository;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@PostMapping
	@Transactional
	public ResponseEntity<ProdutoDto> cadastrar(@RequestBody @Valid ProdutoForm form, UriComponentsBuilder uriBuilder) {
		Produto produto = form.converter();
		produtoRepository.save(produto);
		
		URI uri = uriBuilder.path("/produtos/{id}").buildAndExpand(produto.getId()).toUri();
		return ResponseEntity.created(uri).body(new ProdutoDto(produto));
		
	}
	@GetMapping("/{id}")
	public ResponseEntity<ProdutoDto> detalhar(@PathVariable Long id) {
		Optional<Produto> produto = produtoRepository.findById(id);
		if(produto.isPresent()) {
			return ResponseEntity.ok(new ProdutoDto(produto.get()));
		}
		
		return ResponseEntity.notFound().build();
		
	}
	
	@GetMapping()
	public Page<ProdutoDto> lista(@RequestParam(required = false) String descricao, 
			@PageableDefault( sort = "id", direction = Direction.DESC) Pageable paginacao) {
		
		
		
		
		if (descricao == null) {
			Page<Produto> produtos = produtoRepository.findAll(paginacao);
			return ProdutoDto.converter(produtos);
		} else {
			Page<Produto> topicos =produtoRepository.findByDescricao(descricao, paginacao);
			return ProdutoDto.converter(topicos);
		}
		
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<ProdutoDto> atualizar(@PathVariable Long id, @RequestBody @Valid AtualizacaoProdutoForm form) {
		Optional<Produto> optional = produtoRepository.findById(id);
		if(optional.isPresent()) {
			Produto produto = form.atualizar(id, produtoRepository);
			return ResponseEntity.ok(new ProdutoDto(produto));
		}
		
		return ResponseEntity.notFound().build();
		
		
		
	}
	
	
		
}

