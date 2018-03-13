package com.bjjimage.api.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bjjimage.api.dtos.EventoDto;
import com.bjjimage.api.entities.Evento;
import com.bjjimage.api.entities.Fotografo;
import com.bjjimage.api.repositories.EventoRepository;
import com.bjjimage.api.repositories.FotografoRepository;

@Service
public class EventoServiceImpl implements EventoService {

	@Autowired
	EventoRepository eventoRepository;

	@Autowired
	FotografoRepository fotografoRepository;

	@Override
	public Evento cadastrar(EventoDto eventoDto) {

		return eventoRepository.save(eventoDtoParaEvento(eventoDto, null));
	}

	@Override
	public Evento atualizar(EventoDto eventoDto, Long idEvento) {

		Evento evento = eventoRepository.findOne(idEvento);

		return eventoRepository.save(eventoDtoParaEvento(eventoDto, evento));

	}

	@Override
	public Evento incluirFotografo(String cpf, Long idEvento) {

		Fotografo fotografo = fotografoRepository.findByCpf(cpf);

		Evento evento = eventoRepository.findOne(idEvento);
		evento.getFotografos().add(fotografo);

		return eventoRepository.save(evento);

	}

	@Override
	public List<Evento> buscarTodos() {
		return eventoRepository.findAll();
	}

	@Override
	public Evento buscarEvento(Date date) {
		return eventoRepository.findByDataDoEvento(date);
	}

	private Evento eventoDtoParaEvento(EventoDto eventoDto, Evento evento) {

		if (evento == null) {
			evento = new Evento();
		}

		evento.setNome(eventoDto.getNome());
		evento.setDescricao(eventoDto.getDescricao());
		evento.setDataDoEvento(eventoDto.getDataDoEvento());

		return evento;
	}

}
