package br.com.cep.controller;

import br.com.cep.model.entity.Cep;
import br.com.cep.service.internal.CepService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
@RestController
@AllArgsConstructor
public class CepController {
	private CepService cepService;

	@GetMapping("/ceps/{cep}")
	public ResponseEntity<Cep> findById(@PathVariable String cep){
		Cep cepResult = this.cepService.findByCep(cep);
		return ResponseEntity.ok(cepResult);
	}

	@GetMapping("/ceps")
	public ResponseEntity<List<Cep>> findAll(
			@RequestParam String ibge,
			@RequestParam(required = false) String uf){
		List<Cep> ceps = this.cepService.findByIbgeUf(ibge, uf);
		return ResponseEntity.ok(ceps);
	}
}
