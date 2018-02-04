package com.bjjimage.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.bjjimage.domain.Usuario;

@Repository
public interface UsuarioRepository extends MongoRepository<Usuario, String> {

    List<Usuario> findByNomeLikeIgnoreCase(String nome);

    Usuario findByEmail(String username);
	
}
