package com.bjjimage.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.bjjimage.domain.Foto;

public interface FotoService {

	public void salvar(Foto foto);
	
	public List<Foto> listarTodas();
	
	public Page<Foto> listarTodas(Pageable pageable);
	
}
