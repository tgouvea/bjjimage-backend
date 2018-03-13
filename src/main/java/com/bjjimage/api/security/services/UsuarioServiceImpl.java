package com.bjjimage.api.security.services;

import java.security.Principal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.bjjimage.api.dtos.UsuarioDto;
import com.bjjimage.api.security.entities.Usuario;
import com.bjjimage.api.security.enums.PerfilEnum;
import com.bjjimage.api.security.repositories.UsuarioRepository;
import com.bjjimage.api.utils.SenhaUtils;

@Service
public class UsuarioServiceImpl implements UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public Optional<Usuario> buscarPorEmail(String email) {
		return Optional.ofNullable(this.usuarioRepository.findByEmail(email));
	}

	@Override
	public Usuario cadastrar(UsuarioDto usuarioDto) {
		
		Usuario user = this.usuarioRepository.findByEmail(usuarioDto.getEmail());
		
		if(user == null) {
			Usuario ususario = usuarioDtoParaUsuario(usuarioDto);
			usuarioRepository.save(ususario);
			ususario.setSenha("");
			return ususario;
		}else {
			return null;
		}
		
	}
	
	private Usuario usuarioDtoParaUsuario(UsuarioDto usuarioDto) {
		
		Usuario usuario = new Usuario();
		
		usuario.setEmail(usuarioDto.getEmail());
		usuario.setSenha(SenhaUtils.gerarBCrypt(usuarioDto.getSenha()));
		usuario.setPerfil(PerfilEnum.ROLE_USER);
		
		return usuario;
	}

	@Override
	public Usuario buscarDadosUsuario() {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    String name = auth.getName();
		
		Usuario user = this.usuarioRepository.findByEmail(name);
		user.setSenha("");
		
		return user;
	} 
	
}
