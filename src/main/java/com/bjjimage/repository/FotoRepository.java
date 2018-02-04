package com.bjjimage.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.bjjimage.domain.Foto;

@Repository
public interface FotoRepository extends MongoRepository<Foto, String>{

}
