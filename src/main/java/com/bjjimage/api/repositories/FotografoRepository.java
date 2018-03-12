package com.bjjimage.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bjjimage.api.entities.Fotografo;

public interface FotografoRepository extends JpaRepository<Fotografo, Long>{

	Fotografo findByCpf(String cpf);
	
}
