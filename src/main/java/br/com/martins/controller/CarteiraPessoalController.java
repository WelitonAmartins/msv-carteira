package br.com.martins.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.martins.dto.CarteiraPessoalDTO;
import br.com.martins.entity.CarteiraPessoal;
import br.com.martins.service.CarteiraPessoalService;

@RestController
@RequestMapping(value = "carteira-pessoal")
public class CarteiraPessoalController {
	
	@Autowired
	private CarteiraPessoalService carteiraPessoalService;
	
	@PostMapping
	public ResponseEntity<CarteiraPessoal> cadastrarCarteira(@RequestBody CarteiraPessoalDTO param) {
		return ResponseEntity.ok(this.carteiraPessoalService.salvarNovaCarteira(param));
	}
	
	@GetMapping
	public ResponseEntity<List<CarteiraPessoal>> listarCarteiras() {
		return ResponseEntity.ok(carteiraPessoalService.listarCarteiras());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CarteiraPessoal> buscarCarteiraPorId(@PathVariable Long id) {
		return ResponseEntity.ok().body(this.carteiraPessoalService.buscarPorId(id));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletarCarteira(@PathVariable Long id) {
		this.carteiraPessoalService.buscarPorId(id);
		return ResponseEntity.noContent().build();
	}

}
