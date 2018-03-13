package com.bjjimage.api.dtos;

import org.hibernate.validator.constraints.NotEmpty;

public class DadoBancarioDto {
	
	@NotEmpty(message = "O cpf é obrigatório.")
	private String agenciaBancaria;
	
	@NotEmpty
	private Integer numerobanco;
	
	@NotEmpty
	private String contaBancaria;

	public String getAgenciaBancaria() {
		return agenciaBancaria;
	}

	public void setAgenciaBancaria(String agenciaBancaria) {
		this.agenciaBancaria = agenciaBancaria;
	}

	public Integer getNumerobanco() {
		return numerobanco;
	}

	public void setNumerobanco(Integer numerobanco) {
		this.numerobanco = numerobanco;
	}

	public String getContaBancaria() {
		return contaBancaria;
	}

	public void setContaBancaria(String contaBancaria) {
		this.contaBancaria = contaBancaria;
	}
	
}