package com.example.demo.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.demo.dto.CarrosDto;
import com.example.demo.form.AtualizacaoCarroForm;
import com.example.demo.form.CarroForm;
import com.example.demo.modelo.Carros;
import com.example.demo.repository.CarroRepository;









@CrossOrigin()
@RestController
@RequestMapping("/api")
public class CarsController {
		
	@Autowired
	private CarroRepository carroRepository;
	
	@GetMapping("/cars")
	public List<CarrosDto> listar(String nome, String cor,String marca) {
		
		if(nome != null) {
			List<Carros> carros = carroRepository.findByNome(nome);
			return CarrosDto.converter(carros);
		} else if(cor !=null) {
			List<Carros> carros = carroRepository.findByCor(cor);
			return CarrosDto.converter(carros);
			} else if(marca != null) {
				List<Carros> carros = carroRepository.findByMarca(marca);
				return CarrosDto.converter(carros);
			}else {
			List<Carros> carros = carroRepository.findAll();
			return CarrosDto.converter(carros);	
		}
	
	}


							
				
				
			
			
		
		
		 

//		}

	@GetMapping("/cars/{id}")
	public ResponseEntity<CarrosDto> detalhar(@PathVariable Long id) {
		Optional<Carros> topico = carroRepository.findById(id);
		if(topico.isPresent()) {
			return ResponseEntity.ok(new CarrosDto(topico.get()));
		}
		
		return ResponseEntity.notFound().build();
		
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<CarrosDto> cadastrar(@RequestBody @Valid CarroForm form, UriComponentsBuilder uriBuilder) {
		Carros carro = form.converter(carroRepository);
		carroRepository.save(carro);
		
		URI uri = uriBuilder.path("/cars/{id}").buildAndExpand(carro.getId()).toUri();
		return ResponseEntity.created(uri).body(new CarrosDto(carro));
	}
	@PutMapping("/cars/{id}")
	@Transactional
	public ResponseEntity<CarrosDto> atualizar(@PathVariable Long id, @RequestBody @Valid AtualizacaoCarroForm form) {
		Optional<Carros> optional = carroRepository.findById(id);
		if(optional.isPresent()) {
			Carros carro = form.atualizar(id, carroRepository);
			return ResponseEntity.ok(new CarrosDto(carro));
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/cars/{id}")
	@Transactional
	public ResponseEntity<?> remover (@PathVariable Long id){
		Optional<Carros> optional = carroRepository.findById(id);
		if(optional.isPresent()) {
			carroRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		
		return ResponseEntity.notFound().build();
		
	}
		
}

