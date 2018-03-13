package com.bjjimage.api.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bjjimage.api.dtos.UsuarioDto;
import com.bjjimage.api.responses.Response;
import com.bjjimage.api.security.entities.Usuario;
import com.bjjimage.api.security.services.UsuarioService;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

	@Autowired
	UsuarioService usuarioService;
	
	@GetMapping
	@PreAuthorize("hasAnyRole({'ADMIN','USER'})")
	public ResponseEntity<Response<Usuario>> buscarDadosUsuario () {
		
		Response<Usuario> response = new Response<>();
		
		response.setData(usuarioService.buscarDadosUsuario());
		
		return ResponseEntity.ok(response);
	}
	
	@PostMapping
	public ResponseEntity<Response<Usuario>> cadastrar(@Valid @RequestBody UsuarioDto usuarioDto, BindingResult result){
		
		Response<Usuario> response = new Response<>();
		
		if (result.hasErrors()) {
			result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}
		
		if (!usuarioDto.getSenha().equals(usuarioDto.getConfirmacaoDeSenha())) {
			response.getErrors().add("As senhas não são iguais.");
			return ResponseEntity.badRequest().body(response);
		}
		
		Usuario usuario = usuarioService.cadastrar(usuarioDto);
		
		if (usuario == null) {
			response.getErrors().add("Email de usuário já cadastrado.");
			return ResponseEntity.badRequest().body(response);
		}else {
			response.setData(usuario);
			return ResponseEntity.ok(response);
		}
		
	}
	
}
