package com.bjjimage.api.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "dado_bancario")
public class DadoBancario implements Serializable{
	
	private static final long serialVersionUID = 7534607094656714408L;

	@GeneratedValue(strategy=GenerationType.AUTO)
	@Id
	private Long id;

	private DadoBancario dadoBancario;
	private Date dataCriacao;
	private Date dataAtualizacao;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public DadoBancario getDadoBancario() {
		return dadoBancario;
	}
	public void setDadoBancario(DadoBancario dadoBancario) {
		this.dadoBancario = dadoBancario;
	}
	public Date getDataCriacao() {
		return dataCriacao;
	}
	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	public Date getDataAtualizacao() {
		return dataAtualizacao;
	}
	public void setDataAtualizacao(Date dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}
	
	
	
	
}