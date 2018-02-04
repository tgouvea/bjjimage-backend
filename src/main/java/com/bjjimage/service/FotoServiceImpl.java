package com.bjjimage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.bjjimage.domain.Foto;
import com.bjjimage.repository.FotoRepository;

@Service
public class FotoServiceImpl implements FotoService{

	@Autowired
	FotoRepository fotoRepository;
	
	@Override
	public void salvar(Foto foto) {
		fotoRepository.save(foto);
	}

	@Override
	public List<Foto> listarTodas() {
		return fotoRepository.findAll();
	}

	@Override
	public Page<Foto> listarTodas(Pageable pageable) {

        Page<Foto>fotosPageInfo = fotoRepository.findAll(pageable);
        List<Foto> fotos = fotosPageInfo.getContent();

        return new PageImpl<Foto>(fotos, pageable, fotosPageInfo.getTotalElements());
		
	}

}
