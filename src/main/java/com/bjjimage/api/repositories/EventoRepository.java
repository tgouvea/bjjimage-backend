package com.bjjimage.api.repositories;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bjjimage.api.entities.Evento;

public interface EventoRepository extends JpaRepository<Evento, Long>{

		public Evento findByDataDoEvento(Date dataDoEvento);
	
}
