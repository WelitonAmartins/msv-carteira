package br.com.martins.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.martins.dto.ResponseBolsaDTO;
import br.com.martins.service.ConsultarMercadoService;

@RestController
@RequestMapping(value = "mercado")
public class ConsultarMercadoController {
	
	@Autowired
	private ConsultarMercadoService consultarMercadoService;

	@GetMapping
	public ResponseEntity<ResponseBolsaDTO> consultarMercado(@RequestParam("papel") String papel) {
		return ResponseEntity.ok(this.consultarMercadoService.consultarMercado(papel));
	}
}

