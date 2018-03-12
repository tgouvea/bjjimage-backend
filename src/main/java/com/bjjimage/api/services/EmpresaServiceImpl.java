package com.bjjimage.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.bjjimage.api.entities.Empresa;
import com.bjjimage.api.repositories.EmpresaRepository;

@Service
public class EmpresaServiceImpl implements EmpresaService{
	
	@Autowired
	EmpresaRepository empresaRepository;

	@Override
	@Cacheable("dadosEmpresa")
	public Empresa findByCnpj(String cnpj) {
		return empresaRepository.findByCnpj(cnpj);
	}

}
