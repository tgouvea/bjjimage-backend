package com.bjjimage.api.services;

import java.util.Date;
import java.util.List;

import com.bjjimage.api.dtos.EventoDto;
import com.bjjimage.api.entities.Evento;

public interface EventoService {
	
	
	public Evento cadastrar(EventoDto eventoDto);
	
	public Evento atualizar(EventoDto eventoDto, Long idEvento);
	
	public Evento incluirFotografo(String cpf, Long idEvento);
	
	public List<Evento> buscarTodos();
	
	public Evento buscarEvento(Date date);

}
