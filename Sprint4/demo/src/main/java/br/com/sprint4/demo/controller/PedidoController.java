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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.sprint4.demo.dto.PedidoDto;
import br.com.sprint4.demo.form.AtualizacaoPedidoForm;
import br.com.sprint4.demo.form.PedidoForm;
import br.com.sprint4.demo.modelo.Pedido;
import br.com.sprint4.demo.repository.PedidoRepository;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {
	
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@PostMapping
	@Transactional
	public ResponseEntity<PedidoDto> adicionar(@RequestBody @Valid PedidoForm form, UriComponentsBuilder uriBuilder){
		Pedido pedido = form.converter();
		pedidoRepository.save(pedido);
		
		URI uri = uriBuilder.path("/pedidos/{id}").buildAndExpand(pedido.getId()).toUri();
		return ResponseEntity.created(uri).body(new PedidoDto());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<PedidoDto> detalhar(@PathVariable Long id) {
		Optional<Pedido> pedido = pedidoRepository.findById(id);
		if(pedido.isPresent()) {
			return ResponseEntity.ok(new PedidoDto());
		}
		
		return ResponseEntity.notFound().build();
		
	}
	
	@GetMapping()
	public Page<Pedido> lista(@RequestParam(required = false) String descricao, 
			@PageableDefault( sort = "id", direction = Direction.DESC) Pageable paginacao) {
		
		
		
		
		if (descricao == null) {
			Page<Pedido> pedidos = pedidoRepository.findAll(paginacao);
			return PedidoDto.converter(pedidos);
		} else {
			@SuppressWarnings("unchecked")
			Page<Pedido> pedidos =(Page<Pedido>) pedidoRepository.findAll();
			return PedidoDto.converter(pedidos);
		}
		
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<PedidoDto> atualizar(@PathVariable Long id, @RequestBody @Valid AtualizacaoPedidoForm form) {
		Optional<Pedido> optional = pedidoRepository.findById(id);
		if(optional.isPresent()) {
			@SuppressWarnings("unused")
			Pedido pedido = form.atualizar(id, pedidoRepository);
			return ResponseEntity.ok(new PedidoDto());
		}
		
		return ResponseEntity.notFound().build();
		
		
		
	}
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remover (@PathVariable Long id){
		Optional<Pedido> optional = pedidoRepository.findById(id);
		if(optional.isPresent()) {
			pedidoRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		
		return ResponseEntity.notFound().build();
		
	}
}
