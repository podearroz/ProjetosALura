package br.com.alura.mvc.mudi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.alura.mvc.mudi.dto.requisicaoNovoPedido;

@Controller
@RequestMapping("pedido")
public class PedidoController {
	
	@GetMapping("formulario")
	public String formulario() {
		return "pedido/formulario";
	}
	
	@PostMapping("novo")
	public String novo(requisicaoNovoPedido requisicao) {
		return "pedido/formulario";
	}
}
