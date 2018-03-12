package com.bjjimage.api.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bjjimage.api.entities.Fotografo;
import com.bjjimage.api.responses.Response;
import com.bjjimage.api.services.FotografoService;

@RestController
@RequestMapping("/api/fotografos")
public class FotografoController {

	@Autowired
	FotografoService fotografoService;
	
	@GetMapping(value = "/{cpf}")
	@PreAuthorize("hasAnyRole({'ADMIN','USER'})")
	public ResponseEntity<Response<Fotografo>> buscarFotografo (@PathVariable("cpf") String cpf) {
		
		Response<Fotografo> response = new Response<>();
		
		response.setData(fotografoService.findByCpf(cpf));
		
		System.out.println(response.toString());
		
		return ResponseEntity.ok(response);
	}
	
	@PostMapping
	@PreAuthorize("hasAnyRole('ADMIN')")
	public ResponseEntity<Response<Fotografo>> cadastrar(@Valid @RequestBody Fotografo fotografo, BindingResult result){
		
		Response<Fotografo> response = new Response<>();
		
		if (result.hasErrors()) {
			result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}
		
		
		response.setData(fotografo);
		
		
		return ResponseEntity.ok(response);
	}
	
}
