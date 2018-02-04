package com.bjjimage.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.bjjimage.domain.Perfil;

@Repository
public interface PerfilRepository extends MongoRepository<Perfil, String> {
	
	Perfil findByPerfil(String perfil);
	
}
