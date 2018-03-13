package com.bjjimage.api.controllers;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bjjimage.api.dtos.EventoDto;
import com.bjjimage.api.entities.Evento;
import com.bjjimage.api.responses.Response;
import com.bjjimage.api.services.EventoService;

@RestController
@RequestMapping("/api/eventos")
public class EventoController {
	
	@Autowired
	EventoService eventoService;
	
	@PostMapping
	@PreAuthorize("hasAnyRole('ADMIN')")
	public ResponseEntity<Response<Evento>> criarEvento (@Valid @RequestBody EventoDto eventodto, BindingResult result) {
		
		Response<Evento> response = new Response<>();
		
		if (result.hasErrors()) {
			result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}
		
		response.setData(eventoService.cadastrar(eventodto));
		
		return ResponseEntity.ok(response);
	}
	
	@PatchMapping(value = "/{idEvento}")
	@PreAuthorize("hasAnyRole('ADMIN')")
	public ResponseEntity<Response<Evento>> atualizarEvento (@Valid @RequestBody EventoDto eventodto, @PathVariable("idEvento") Long idEvento, BindingResult result) {
		
		Response<Evento> response = new Response<>();
		
		if (result.hasErrors()) {
			result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}
		
		response.setData(eventoService.atualizar(eventodto, idEvento));
		
		return ResponseEntity.ok(response);
	}
	
	@GetMapping
	@PreAuthorize("hasAnyRole({'ADMIN','USER'})")
	public ResponseEntity<Response<List<Evento>>> buscarTodosOsEventos (@Valid BindingResult result) {
		
		Response<List<Evento>> response = new Response<>();
		
		if (result.hasErrors()) {
			result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}
		
		response.setData(eventoService.buscarTodos());
		
		return ResponseEntity.ok(response);
	}
	
	
	@GetMapping(value = "/{data}")
	@PreAuthorize("hasAnyRole({'ADMIN','USER'})")
	public ResponseEntity<Response<Evento>> buscarTodosOsEventos (@Valid @PathVariable("data") Date data, BindingResult result) {
		
		Response<Evento> response = new Response<>();
		
		if (result.hasErrors()) {
			result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}
		
		response.setData(eventoService.buscarEvento(data));
		
		return ResponseEntity.ok(response);
	}
	

}
