package com.bjjimage.api.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bjjimage.api.entities.Evento;
import com.bjjimage.api.responses.Response;

@RestController
@RequestMapping("/api/eventos")
public class EventoController {
	
	@GetMapping
	@PreAuthorize("hasAnyRole('ADMIN')")
	public ResponseEntity<Response<Evento>> criarEvento (@RequestBody Evento evento) {
		
		Response<Evento> response = new Response<>();
		
		
		return ResponseEntity.ok(response);
	}
	

}
