package com.bjjimage.api.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class VersionamentoController {

	@GetMapping(value = "/v1/bemvindo/{nome}")
	public ResponseEntity<String> buscaExemploV1(@PathVariable("nome") String nome){
		
		return ResponseEntity.ok(String.format("API v1: bem vindo %s!", nome));
		
	}
	
	@GetMapping(value = "/v2/bemvindo/{nome}")
	public ResponseEntity<String> buscaExemploV2(@PathVariable("nome") String nome){
		
		return ResponseEntity.ok(String.format("API v2: bem vindo %s!", nome));
		
	}
	
	@GetMapping(value = "/bemvindo/{nome}", headers="X-API-Version=v1")
	public ResponseEntity<String> buscaExemploHeaderV1(@PathVariable("nome") String nome){
		
		return ResponseEntity.ok(String.format("API v1: bem vindo %s!", nome));
		
	}
	
	@GetMapping(value = "/bemvindo/{nome}", headers="X-API-Version=v2")
	public ResponseEntity<String> buscaExemploHeaderV2(@PathVariable("nome") String nome){
		
		return ResponseEntity.ok(String.format("API v1: bem vindo %s!", nome));
		
	}
	
}
