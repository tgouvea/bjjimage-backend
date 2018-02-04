package com.bjjimage.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.bjjimage.domain.Usuario;
import com.bjjimage.repository.UsuarioRepository;

@Service
public class CustomUserDetailService implements UserDetailsService {

	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		
		Usuario usuario = usuarioRepository.findByEmail(userName);	
		return new CustomUserDetail(usuario);
	}
	

}
