package com.bjjimage.api.dtos;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.URL;
import org.hibernate.validator.constraints.br.CPF;

public class FotografoDto {

	@NotEmpty(message = "O nome é obrigatório.")
	@Length(min = 3, max = 100)
	private String nome;
	
	@NotEmpty(message = "O cpf é obrigatório.")
	@CPF(message = "Informar um cpf valido.")
	private String cpf;
	
	@NotEmpty(message = "O cpf é obrigatório.")
	@URL(message = "Informar uma URL valida.")
	private String linkPortifolio;
	
	@NotNull(message = "Os dados bancarios são obrigatórios")
	private DadoBancarioDto dadoBancario;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getLinkPortifolio() {
		return linkPortifolio;
	}

	public void setLinkPortifolio(String linkPortifolio) {
		this.linkPortifolio = linkPortifolio;
	}

	public DadoBancarioDto getDadoBancario() {
		return dadoBancario;
	}

	public void setDadoBancario(DadoBancarioDto dadoBancario) {
		this.dadoBancario = dadoBancario;
	}

	
	
}
