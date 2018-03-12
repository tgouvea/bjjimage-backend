package com.bjjimage.api.services;

import com.bjjimage.api.entities.Empresa;

public interface EmpresaService {
	
	Empresa findByCnpj(String cnpj);

}
