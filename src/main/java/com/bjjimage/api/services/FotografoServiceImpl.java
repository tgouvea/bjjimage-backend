package com.bjjimage.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bjjimage.api.entities.Fotografo;
import com.bjjimage.api.repositories.FotografoRepository;

@Service
public class FotografoServiceImpl implements FotografoService{
	
	@Autowired
	FotografoRepository empresaRepository;

	@Override
	public Fotografo findByCpf(String cpf) {
		return empresaRepository.findByCpf(cpf);
	}

}
