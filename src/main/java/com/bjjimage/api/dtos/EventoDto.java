package com.bjjimage.api.dtos;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

public class EventoDto {

	@NotEmpty(message = "O nome do evento é obrigatório.")
	@Length(min = 3, max = 100)
	private String nome;

	@NotEmpty(message = "O nome do evento é obrigatório.")
	@Length(min = 5, max = 255)
	private String descricao;

	@NotNull(message = "A data do evento é obrigatória")
	private Date dataDoEvento;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getDataDoEvento() {
		return dataDoEvento;
	}

	public void setDataDoEvento(Date dataDoEvento) {
		this.dataDoEvento = dataDoEvento;
	}

}
